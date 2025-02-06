package Actions.initActions;

import Actions.SpawnAction;
import Objects.Herbivore;
import Objects.Predator;
import Simulation.MyMap;

public class PlacePreds extends SpawnAction<Predator> {
    public PlacePreds() {
        super.spawnRate = 0.0034; //Процент клеток, заполненных объектом класса, где 100% это все клетки поля
        super.respawnRate = 0; //сколько объектов в процентах от общего количества объектов класса должно остаться, чтобы запустить респавн
    }

    @Override
    protected Predator createEntity(MyMap map) {
        map.addPredsCount();
        return new Predator();
    }

    @Override
    protected int EntityCounter(MyMap map) {
        return map.getPredsCount();
    }

    @Override
    protected void printInfo() {
        System.out.println("INFO: More predators added on the map");
    }
}
