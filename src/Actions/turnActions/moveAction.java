package Actions.turnActions;

import Actions.Action;
import Objects.*;
import Simulation.MyMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class moveAction extends Action {
    @Override
    public void operation(MyMap map) {
        List<Map.Entry<Position, Entity>> creatures = new ArrayList<>(map.getEntry());
        for (Map.Entry<Position, Entity> entry : creatures) {
            Entity entity = entry.getValue();
            Position oldPos = entry.getKey();

            if (entity instanceof Herbivore || entity instanceof Predator) {
                Creature creature = (Creature) entity;
                Position newPos = creature.makeMove(map, oldPos);
                if (!oldPos.equals(newPos)) {
                    map.removeEntity(oldPos);
                    map.addEntity(newPos, creature);
                }
            }
        }
    }
}
