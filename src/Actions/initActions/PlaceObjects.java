package Actions.initActions;

import Actions.SpawnAction;
import Objects.Entity;
import Objects.Predator;
import Objects.Rock;
import Objects.Tree;
import Simulation.MyMap;

import java.util.Random;

public class PlaceObjects extends SpawnAction<Entity> {
    private static int objectsCounter = 0;

    public PlaceObjects() {
        super.spawnRate = 0.0714; //Процент клеток, заполненных объектом класса, где 100% это все клетки поля
        super.respawnRate = 0; //сколько объектов в процентах от общего количества объектов класса должно остаться, чтобы запустить респавн
    }

    @Override
    protected Entity createEntity(MyMap map) {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            objectsCounter++;
            return new Tree();
        } else {
            objectsCounter++;
            return new Rock();
        }
    }

    @Override
    protected int EntityCounter(MyMap map) {
        return objectsCounter;
    }

    @Override
    protected void printInfo() {
        System.out.println("INFO: Objects added on the map");
    }
}
