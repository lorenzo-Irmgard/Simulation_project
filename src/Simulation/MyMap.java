package Simulation;

import Objects.Entity;
import Objects.Position;

import java.util.*;

public class MyMap {
    private final Map<Position, Entity> map;
    private final int WIDTH = 30;
    private final int HEIGHT = 20;
    private final List<Position> neighbors = new ArrayList<>();
    private int herbsCount = 0;
    private int grassCount = 0;
    private int predsCount = 0;

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHerbsCount() {
        return herbsCount;
    }

    public int getGrassCount() {
        return grassCount;
    }

    public int getPredsCount() {
        return predsCount;
    }

    public void addGrassCount() {
        grassCount += 1;
    }

    public void addHerbsCount() {
        herbsCount += 1;
    }

    public void addPredsCount() {
        predsCount += 1;
    }

    public void subGrassCount() {
        grassCount -= 1;
    }

    public void subPredsCount() {
        predsCount -= 1;
    }

    public void subHerbsCount() {
        herbsCount -= 1;
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
