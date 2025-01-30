package Simulation;

import Objects.Entity;
import Objects.Position;

import java.util.*;

public class MyMap {
    private Map<Position, Entity> map;
    private final int WIDTH = 50;
    private final int HEIGHT = 25;
    private final List<Position> neighbors = new ArrayList<>();

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public List<Position> getNeighbors() {
        return neighbors;
    }

    public MyMap() {
        map = new HashMap<>();
        neighbors.add(new Position(0, 1));
        neighbors.add(new Position(1, 0));
        neighbors.add(new Position(0, -1));
        neighbors.add(new Position(-1, 0));
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

    public Set<Map.Entry<Position, Entity>> getEntry() {
        return map.entrySet();
    }

    public boolean contains(Position pos) {
        return map.containsKey(pos);
    }
    
    public boolean validPositionCheck (Position pos) {
        return pos.getX() < WIDTH && pos.getX() >= 0 && pos.getY() < HEIGHT && pos.getY() >= 0;
    }
}
