package Objects;

import Simulation.MyMap;

public class Herbivore extends Creature {
    private static final int START_HEALTH = 9;
    private static final int SPEED = 4;
    private static final String ICON = "\uD83E\uDD8C";

    public Herbivore() {
        super(SPEED, START_HEALTH, ICON, entity -> entity instanceof Grass);
    }

    @Override
    public String printStatus() {
        return "Herbivore(" + getHealth() + " HP)";
    }

    @Override
    public void bite(MyMap map) {
        System.out.println("ate grass on position:" + targetPos);
        map.removeEntity(targetPos);
        map.subGrassCount();
        if (getHealth() < START_HEALTH - 1) {
            setHealth(getHealth() + 2);
        } else {
            setHealth(START_HEALTH);
        }
    }
}
