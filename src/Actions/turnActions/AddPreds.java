package Actions.turnActions;

import Actions.SpawnAction;
import Objects.Predator;
import Simulation.MyMap;

public class AddPreds extends SpawnAction {
    @Override
    public void operation(MyMap map) {
        int count = map.getHerbsCount() / 2;
        if (map.getPredsCount() == 0) {
            for (int i = 0; i < count; i++) {
                map.addEntity(getValidPosition(map), new Predator());
                map.addPredsCount();
            }

        }
    }
}
