package Simulation;

import Objects.Entity;
import Objects.Position;
import java.util.HashMap;
import java.util.Map;

public class MyMap {
    private Map<Position, Entity> map;

    public MyMap() {
        map = new HashMap<>();
    }

    public void addEntity(Position pos, Entity ent) {
        map.put(pos, ent);
    }

    public void removeEntity(Position pos) {
        map.remove(pos);
    }

    public Entity getEntity(Position pos) {
        return map.get(pos);
    }

    public boolean contains(Position pos) {
        return map.containsKey(pos);
    }
}
