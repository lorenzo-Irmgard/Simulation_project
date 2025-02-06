package Actions.initActions;

import Actions.SpawnAction;
import Objects.Grass;
import Simulation.MyMap;

public class PlaceGrass extends SpawnAction<Grass> {
    public PlaceGrass() {
        super.spawnRate = 0.02; //Процент клеток, заполненных объектом класса, где 100% это все клетки поля
        super.respawnRate = 0.8; //сколько объектов от общего количества объектов класса должно остаться, чтобы запустить респавн
    }

    @Override
    protected Grass createEntity(MyMap map) {
        map.addGrassCount();
        return new Grass();
    }

    @Override
    protected int EntityCounter(MyMap map) {
        return map.getGrassCount();
    }

    @Override
    protected void printInfo() {
        System.out.println("INFO: More grass added on the map");
    }
}
