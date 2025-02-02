package Actions.initActions;

import Actions.spawnAction;
import Objects.Herbivore;
import Simulation.MyMap;

import java.util.Random;

public class placeHerbs extends spawnAction {
    @Override
    public void operation(MyMap map) {
        int place = map.getWIDTH() * map.getHEIGHT();
        Random rand = new Random();
        int count = place / 150;
        for (int i = 0; i < count; i++) {
            map.addEntity(getValidPosition(map), new Herbivore());
            map.setHerbsCount(map.getHerbsCount() + 1);
        }
    }
}
