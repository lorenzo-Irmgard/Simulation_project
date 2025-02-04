package Objects;

import Simulation.MyMap;

public class Predator extends Creature{
    private static final int START_HEALTH = 9;
    private static final int SPEED = 3;
    private static final int STRENGTH = 3;
    private static final String ICON = "\uD83D\uDC3A";

    public Predator() {
        super(SPEED, START_HEALTH, ICON, entity -> entity instanceof Herbivore);
    }

    @Override
    public String printStatus() {
        return "Predator(" + getHealth() + " HP)";
    }

    @Override
    public void bite(MyMap map) {
        Herbivore herb = (Herbivore) map.getEntity(super.targetPos);
        map.removeEntity(targetPos);
        herb.setHealth(herb.getHealth() - STRENGTH);
        if (herb.getHealth() > 0) {
            map.addEntity(targetPos, herb);
            System.out.println("damaged herbivore on position: " + targetPos);
            setHealth(Math.min(getHealth() + 3, START_HEALTH));
        } else {
            map.subHerbsCount();
            System.out.println("killed herbivore on position " + targetPos);
            if (getHealth() + 3 > START_HEALTH) {
                setHealth(START_HEALTH);
            } else {
                setHealth(getHealth() + 6);
            }
        }
    }


}
