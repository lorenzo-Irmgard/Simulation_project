package Objects;

public class Deer extends Creature {
    private static final String ICON = "\uD83E\uDD8C";
    private static final int START_HEALTH = 100;
    private static final int ID = 4;
    private static final int SPEED = 15;

    public Deer() {
        super(SPEED, START_HEALTH, ID, ICON);
    }

    public void eat() {

    }
}
