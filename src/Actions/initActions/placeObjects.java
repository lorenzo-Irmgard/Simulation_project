package Actions.initActions;

import Actions.spawnAction;
import Objects.Rock;
import Objects.Tree;
import Simulation.MyMap;

import java.util.Random;

public class placeObjects extends spawnAction {
    @Override
    public void operation(MyMap map) {
        int place = map.getWIDTH() * map.getHEIGHT();
        Random rand = new Random();
        int count = place / 14;
        for (int i = 0; i < count; i++) {
            if (rand.nextInt(1, 3) == 1) {
                map.addEntity(getValidPosition(map), new Tree());
            } else {
                map.addEntity(getValidPosition(map), new Rock());
            }
        }
    }
}
