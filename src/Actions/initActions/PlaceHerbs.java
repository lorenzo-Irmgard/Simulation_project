package Actions.initActions;

import Actions.SpawnAction;
import Objects.Herbivore;
import Simulation.MyMap;

import java.util.Random;

public class PlaceHerbs extends SpawnAction {
    @Override
    public void operation(MyMap map) {
        int place = map.getWIDTH() * map.getHEIGHT();
        int count = place / 150;
        for (int i = 0; i < count; i++) {
            map.addEntity(getValidPosition(map), new Herbivore());
            map.addHerbsCount();
        }
    }
}
