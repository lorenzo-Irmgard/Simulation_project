package Actions;

import Objects.Position;
import Simulation.MyMap;

import java.util.Random;

public abstract class spawnAction extends Action {
    public Position getValidPosition(MyMap map) {
        Random rand = new Random();
        while (true) {
            Position pos = new Position(rand.nextInt(0, map.getWIDTH()), rand.nextInt(0, map.getHEIGHT()));
            if (map.contains(pos)) continue;
            return pos;
        }
    }
}