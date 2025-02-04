package Actions.turnActions;

import Actions.Action;
import Objects.*;
import Simulation.MyMap;
import Simulation.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MoveAction extends Action {
    @Override
    public void operation(MyMap map) {
        int count = 1;
        List<Map.Entry<Position, Entity>> creatures = new ArrayList<>(map.getEntry());
        for (Map.Entry<Position, Entity> entry : creatures) {
            Entity entity = entry.getValue();
            Position oldPos = entry.getKey();
            if (!map.contains(oldPos)) continue;
            if (entity instanceof Herbivore || entity instanceof Predator) {
                Creature creature = (Creature) entity;
                System.out.println("\n\n\n\n\n");
                System.out.println(creature.printStatus() + " on " + oldPos + " make's move");
                Position newPos = creature.makeMove(map, oldPos);
                creature.setHealth(creature.getHealth() - 1);
                if (creature.getHealth() > 0) {
                    if (!oldPos.equals(newPos)) {
                        System.out.println("to new position:" + newPos);
                        map.removeEntity(oldPos);
                        map.addEntity(newPos, creature);
                    }
                } else {
                    System.out.println("died of hunger");
                    map.removeEntity(oldPos);
                    if (entity instanceof Herbivore) {
                        map.subHerbsCount();
                    } else {
                        map.subPredsCount();
                    }
                }
                Simulation.fieldRender(count);
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
