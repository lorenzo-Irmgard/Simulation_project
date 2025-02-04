package Actions.initActions;

import Actions.SpawnAction;
import Objects.Grass;
import Simulation.MyMap;

import java.util.Random;

public class PlaceGrass extends SpawnAction {
    @Override
    public void operation(MyMap map) {
        int place = map.getWIDTH() * map.getHEIGHT();
        int count = place / 50;
        for (int i = 0; i < count; i++) {
            map.addEntity(getValidPosition(map), new Grass());
            map.addGrassCount();
        }
    }
}
