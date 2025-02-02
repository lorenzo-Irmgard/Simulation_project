package Actions.initActions;

import Actions.spawnAction;
import Objects.Predator;
import Simulation.MyMap;

import java.util.Random;

public class placePreds extends spawnAction {

    @Override
    public void operation(MyMap map) {
        int place = map.getWIDTH() * map.getHEIGHT();
        Random rand = new Random();
        int count = place / 200;
        for (int i = 0; i < count; i++) {
            map.addEntity(getValidPosition(map), new Predator());
            map.setPredsCount(map.getPredsCount() + 1);
        }
    }
}
