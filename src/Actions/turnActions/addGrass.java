package Actions.turnActions;

import Actions.spawnAction;
import Simulation.MyMap;

public class addGrass extends spawnAction {
    @Override
    public void operation(MyMap map) {
        int place = map.getHEIGHT() * map.getWIDTH();
        int count = place/50;
        //TODO дописать спавн травы и травоядных
    }
}
