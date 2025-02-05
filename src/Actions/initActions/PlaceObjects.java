package Actions.initActions;

import Actions.SpawnAction;
import Objects.Rock;
import Objects.Tree;
import Simulation.MyMap;

import java.util.Random;

public class PlaceObjects extends SpawnAction {
    @Override
    public void operation(MyMap map) {
        Random rand = new Random();
        int count = (map.getWIDTH() * map.getHEIGHT()) / 14;
        for (int i = 0; i < count; i++) {
            if (rand.nextInt(1, 3) == 1) {
                map.addEntity(getValidPosition(map), new Tree());
            } else {
                map.addEntity(getValidPosition(map), new Rock());
            }
        }
    }
}
