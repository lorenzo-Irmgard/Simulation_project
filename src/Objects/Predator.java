package Objects;

import Simulation.MyMap;

public class Predator extends Creature{
    private static final int START_HEALTH = 4;
    private static final int SPEED = 4;
    private static final int STRENGTH = 2;
    private static final String ICON = "\uD83D\uDC3A";

    public Predator() {
        super(SPEED, START_HEALTH, ICON, entity -> entity instanceof Herbivore);
    }

    @Override
    public void bite(MyMap map) {
        Herbivore herb = (Herbivore) map.getEntity(super.targetPos);
        map.removeEntity(targetPos);
        herb.setHealth(herb.getHealth() - STRENGTH);
        if (herb.getHealth() > 0) map.addEntity(targetPos, herb);
        if (herb.getHealth() <= 0) map.setHerbsCount(map.getHerbsCount() - 1);
    }
}
