package Actions.initActions;

import Actions.spawnAction;
import Objects.Grass;
import Simulation.MyMap;

import java.util.Random;

public class placeGrass extends spawnAction {
    @Override
    public void operation(MyMap map) {
        int place = map.getWIDTH() * map.getHEIGHT();
        Random rand = new Random();
        int count = place / 50;
        for (int i = 0; i < count; i++) {
            map.addEntity(getValidPosition(map), new Grass());
            map.setGrassCount(map.getGrassCount() + 1);
        }
    }
}
