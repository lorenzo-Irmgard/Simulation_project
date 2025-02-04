package Actions.turnActions;

import Actions.SpawnAction;
import Objects.Herbivore;
import Simulation.MyMap;

public class AddHerbs extends SpawnAction {

    @Override
    public void operation(MyMap map) {
        int place = map.getHEIGHT() * map.getWIDTH();
        int count = place / 150;
        if (map.getHerbsCount() <= count - count/2) {
            for (int i = 0; i < count/2; i++) {
                map.addEntity(getValidPosition(map), new Herbivore());
                map.addHerbsCount();
            }

        }
    }
}
