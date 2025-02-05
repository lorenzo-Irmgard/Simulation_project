package Actions.initActions;

import Actions.SpawnAction;
import Objects.Grass;
import Simulation.MyMap;

public class PlaceGrass extends SpawnAction {
    @Override
    public void operation(MyMap map) {
        int count = (map.getWIDTH() * map.getHEIGHT()) / 50;
        for (int i = 0; i < count; i++) {
            map.addEntity(getValidPosition(map), new Grass());
            map.addGrassCount();
        }
    }
}
