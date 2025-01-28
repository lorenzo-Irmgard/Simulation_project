package Objects;

public class Predator extends Creature{
    private static final int START_HEALTH = 4;
    private static final int SPEED = 4;
    private static final String ICON = "\uD83D\uDC3A";

    public Predator() {
        super(SPEED, START_HEALTH, ICON, entity -> entity instanceof Herbivore);
    }
}
