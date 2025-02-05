package Actions.initActions;

import Actions.SpawnAction;
import Objects.Predator;
import Simulation.MyMap;

public class PlacePreds extends SpawnAction {

    @Override
    public void operation(MyMap map) {
        int count = ((map.getWIDTH() * map.getHEIGHT()) / 150) / 2;
        for (int i = 0; i < count; i++) {
            map.addEntity(getValidPosition(map), new Predator());
            map.addPredsCount();
        }
    }
}
