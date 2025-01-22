package Objects;

public abstract class Creature extends Entity{
    private final int SPEED;
    private int health;

    protected Creature (int speed, int health, int id, String icon) {
        super(id, icon);
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

    public int[] makeMove() {
        return getCoordinates();
    }
}
