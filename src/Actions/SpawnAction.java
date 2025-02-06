package Actions;

import Objects.Entity;
import Objects.Position;
import Simulation.MyMap;
import java.util.Random;

public abstract class SpawnAction <T extends Entity> extends Action {
    protected double spawnRate;
    protected double respawnRate;

    public void operation(MyMap map) {
        int count = (int)((map.getWIDTH() * map.getHEIGHT()) * spawnRate);
        if (EntityCounter(map) <= (int)(count * respawnRate)) {
            while (EntityCounter(map) < count) {
                map.addEntity(getValidPosition(map), createEntity(map));
            }
        printInfo();
        }
    }

    protected abstract T createEntity(MyMap map);

    protected abstract int EntityCounter(MyMap map);

    protected abstract void printInfo();

    public Position getValidPosition(MyMap map) {
        Random rand = new Random();
        while (true) {
            Position pos = new Position(rand.nextInt(0, map.getWIDTH()), rand.nextInt(0, map.getHEIGHT()));
            if (map.contains(pos)) continue;
            return pos;
        }
    }
}