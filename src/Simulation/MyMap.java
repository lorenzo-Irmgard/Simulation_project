package Simulation;

import Objects.Entity;
import Objects.Position;

import java.util.*;

public class MyMap {
    private Map<Position, Entity> map;
    private final int WIDTH = 50;
    private final int HEIGHT = 25;
    private final List<Position> neighbors = new ArrayList<>();
    private int herbsCount = 0;
    private int predsCount = 0;
    private int grassCount = 0;

    public int getWIDTH() {
        return WIDTH;
    }

    public void setGrassCount(int grassCount) {
        this.grassCount = grassCount;
    }

    public void setPredsCount(int predsCount) {
        this.predsCount = predsCount;
    }

    public void setHerbsCount(int herbsCount) {
        this.herbsCount = herbsCount;
    }

    public int getHerbsCount() {
        return herbsCount;
    }

    public int getPredsCount() {
        return predsCount;
    }

    public int getGrassCount() {
        return grassCount;
    }

    public Set<Position> getPositions() {
        return map.keySet();
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
