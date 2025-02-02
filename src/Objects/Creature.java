package Objects;
import Simulation.MyMap;

import java.util.*;
import java.util.function.Predicate;

public abstract class Creature extends Entity{
    private final int SPEED;
    private int health;
    private final Predicate<Entity> TARGETCLASS;
    protected Position targetPos;

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
        if (targetCheck(startPos, map)) {
            bite(map);
            return startPos;
        }
        return findTarget(startPos, map);
    }

    public abstract void bite(MyMap map);

    private Position findTarget(Position startPos, MyMap map) {
        Queue<Position> toCheck = new LinkedList<>();
        Map<Position, Position> history = new HashMap<>();
        Stack<Position> path;
        Position nextPos = startPos;
        toCheck.add(startPos);
        history.put(startPos, null);
        while (!toCheck.isEmpty()) {
            Position current = toCheck.poll();

            if (targetCheck(current, map)) {
                path = restorePath(history, current);
                int cnt = 0;
                while (cnt < SPEED && !path.empty()) {
                    nextPos = path.pop();
                    cnt++;
                }
                break;
            }

            for(Position p : map.getNeighbors()) {
                Position neighbor = new Position(current.getX() + p.getX(), current.getY() + p.getY());
                if (map.validPositionCheck(neighbor) && !history.containsKey(neighbor) && !map.contains(neighbor)) {
                    toCheck.add(neighbor);
                    history.put(neighbor, current);
                }
            }
        }
        return nextPos;
    }

    private boolean targetCheck(Position pos, MyMap map) {
        for (Position p : map.getNeighbors()) {
            Position check = new Position(pos.getX() + p.getX(), pos.getY() + p.getY());
            if (map.contains(check) && TARGETCLASS.test(map.getEntity(check))) {
                targetPos = check;
                return true;
            }
        }
        return false;
    }

    private Stack<Position> restorePath(Map<Position, Position> history, Position end) {
        Stack<Position> path = new Stack<>();
        while (history.get(end) != null) {
            path.push(end);
            end = history.get(end);
        }
        return path;
    }
}





/*
void findTarget(Position startPos, MyMap map) {
        Queue<Position> toCheck = new LinkedList<>();
        List<Position> checked = new LinkedList<>();
//        Map<Position, Position> path = new HashMap<>();
        toCheck.add(startPos);
//        path.put(startPos, null);
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
 */
