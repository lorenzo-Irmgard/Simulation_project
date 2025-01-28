package Objects;
import Simulation.MyMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Predicate;

public abstract class Creature extends Entity{
    private final int SPEED;
    private int health;
    protected Position targetPosition;
    private final Predicate<Entity> TARGETCLASS;

    protected Creature (int speed, int health, String ICON, Predicate<Entity> targetClass) {
        super(ICON);
        this.health = health;
        this.SPEED = speed;
        this.TARGETCLASS = targetClass;
    }

    public int getSPEED() {
        return SPEED;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Position makeMove(MyMap map, Position startPos) {
        Position nextPos = startPos;
        switch (targetCheck(startPos, map)) {
            case 0:
                System.out.println("eating");
                break;
            case 1:
                nextPos = moveToTarget(startPos);
                break;
            case 2:
                findTarget(startPos, map);
                nextPos = moveToTarget(startPos);
                break;
        }
        return nextPos;
    }

    private Position moveToTarget(Position startPos) {
        return startPos;
    }

    void findTarget(Position startPos, MyMap map) {
        Queue<Position> toCheck = new LinkedList<>();
        List<Position> checked = new LinkedList<>();
        toCheck.add(startPos);
        while (!toCheck.isEmpty()) {
            Position current = toCheck.remove();
            if (checked.contains(current)) continue;

            if (map.contains(current) && map.getEntity(current) != null && TARGETCLASS.test(map.getEntity(current))) {
                targetPosition = current;
                break;
            }

            checked.add(current);

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    Position neighbor = new Position(current.getX() + i, current.getY() + j);
                    if (checked.contains(neighbor)) continue;
                    if (map.validPositionCheck(neighbor)) {
                        toCheck.add(neighbor);
                    }
                }
            }
        }
    }

    int targetCheck(Position pos, MyMap map) {
        List<Position> roundPos = new ArrayList<>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 && j != 0) {
                    Position p = new Position(pos.getX() + i, pos.getY() + j);
                    if (map.validPositionCheck(p)) roundPos.add(p);
                }
            }
        }

        if (map.contains(targetPosition) && TARGETCLASS.test(map.getEntity(targetPosition))) {
            if (roundPos.contains(targetPosition)) return 0;
            return 1;
        }
        return 2;
    }
}
