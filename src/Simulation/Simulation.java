package Simulation;
/*
UNICODES for emoji
Grass: uD83C uDF3F
Tree: uD83C uDF34
Rock: u26F0 uFE0F
Rabbit: 🐇
Giraffe: 🦒
Deer: 🦌

wolf: 🐺
Lion:🦁
Eagle: 🦅
 */

import Objects.Entity;
import Objects.Grass;
import Objects.Herbivore;
import Objects.Position;

import java.util.Map;
import java.util.Scanner;

public class Simulation {
    private static int count;
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        startSimulation();
    }

    private static void startSimulation() {
       count = 0;
        MyMap map = new MyMap();
        initEntity(map);
        while (true) {
            Position pos;
            fieldRender(map);
            if (scan.nextLine().equals("e")) {
                break;
            }
            for (Map.Entry<Position, Entity> entr : map.getEntry()) { //TODO исправить, не работает!
                if (entr.getValue().getClass() == Herbivore.class) { //TODO Пересмотреть видео из обучалки по джава, про изменение коллекций в цикле
                    Herbivore herb = (Herbivore) entr.getValue();
                    map.removeEntity(entr.getKey());
                    map.addEntity(herb.makeMove(map, entr.getKey()), herb);
                }
            }
            count++;
        }
    }

    private static void fieldRender(MyMap map) {
        for (int i = -1; i < map.getHEIGHT() + 1; i++) {
            for (int j = -1; j < map.getWIDTH() + 1; j++) {
                Position pos = new Position(j, i);
                if (j < 0 || j == map.getWIDTH()) {
                    System.out.print("|");
                } else if (i < 0 || i == map.getHEIGHT()) {
                    System.out.print("----");
                } else if (map.contains(pos)) {
                    System.out.print(" " + map.getEntity(pos) + " ");
                } else {
                    System.out.print(" .. ");
                }
            }
            System.out.println();
        }
        System.out.println("INFO:\n1)turn number: " + count + "\n2)Herbivores: " + " cnt of Herbs" + "\n3)Predators: " + "cnt of Preds");
    }

    private static void initEntity(MyMap map) {
        map.addEntity(new Position(1, 0), new Herbivore());
        map.addEntity(new Position(49,24), new Grass());
    }
}