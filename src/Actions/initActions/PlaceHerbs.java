package Actions.initActions;

import Actions.SpawnAction;
import Objects.Grass;
import Objects.Herbivore;
import Simulation.MyMap;

public class PlaceHerbs extends SpawnAction<Herbivore> {
    public PlaceHerbs() {
        super.spawnRate = 0.0067; //Процент клеток, заполненных объектом класса, где 100% это все клетки поля
        super.respawnRate = 0.5; //сколько объектов в процентах от общего количества объектов класса должно остаться, чтобы запустить респавн
    }

    @Override
    protected Herbivore createEntity(MyMap map) {
        map.addHerbsCount();
        return new Herbivore();
    }

    @Override
    protected int EntityCounter(MyMap map) {
        return map.getHerbsCount();
    }

    @Override
    protected void printInfo() {
        System.out.println("INFO: More herbivores added on the map");
    }
}
