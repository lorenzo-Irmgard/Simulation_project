package Objects;

import Simulation.MyMap;

public class Herbivore extends Creature {
    private static final int START_HEALTH = 4;
    private static final int SPEED = 4;
    private static final String ICON = "\uD83E\uDD8C";

    public Herbivore() {
        super(SPEED, START_HEALTH, ICON, entity -> entity instanceof Grass);
    }

    @Override
    public void bite(MyMap map) {
        map.removeEntity(targetPos);
        map.setGrassCount(map.getGrassCount() - 1);
    }
}
