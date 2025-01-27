package Objects;
import Simulation.MyMap;

public abstract class Creature extends Entity{
    private final int SPEED;
    private int health;
    private Position targetPosition;

    protected Creature (int speed, int health, String ICON) {
        super(ICON);
        this.health = health;
        this.SPEED = speed;
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

    public Position getTargetPosition() {
        return targetPosition;
    }

    public Position makeMove(MyMap map, Position startPos) {
        Position nextPos = startPos;
        switch (targetCheck(startPos)) {
            case 0:
                System.out.println("eating");
                break;
            case 1:
                nextPos = moveToTarget(startPos);
                break;
            case 2:
                targetPosition = findTarget(startPos);
                nextPos = moveToTarget(startPos);
                break;
        }
        return nextPos;
    }

    private Position moveToTarget(Position startPos) {
        return startPos;
    }

    abstract Position findTarget(Position startPos);

    abstract int targetCheck(Position startPos);
}
