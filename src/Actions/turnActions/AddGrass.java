package Actions.turnActions;

import Actions.SpawnAction;
import Objects.Grass;
import Simulation.MyMap;

public class AddGrass extends SpawnAction {
    @Override
    public void operation(MyMap map) {
        int place = map.getHEIGHT() * map.getWIDTH();
        int count = place/50;
        if (map.getGrassCount() < count) {
            for(int i = 0; i < count/7 + 1; i++) {
            map.addEntity(getValidPosition(map), new Grass());
            map.addGrassCount();
            }
        }
    }
}
