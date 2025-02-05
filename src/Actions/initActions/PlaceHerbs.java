package Actions.initActions;

import Actions.SpawnAction;
import Objects.Herbivore;
import Simulation.MyMap;

public class PlaceHerbs extends SpawnAction {
    @Override
    public void operation(MyMap map) {
        int count = (map.getWIDTH() * map.getHEIGHT()) / 150;
        for (int i = 0; i < count; i++) {
            map.addEntity(getValidPosition(map), new Herbivore());
            map.addHerbsCount();
        }
    }
}
