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

import Objects.*;

import java.util.*;

public class Simulation {
    private static int count = 0;
    private static final Scanner scan = new Scanner(System.in);
    private static MyMap map;

    public static void main(String[] args) {
        int exitCode = 0;
        while (exitCode != 1) {
            if (exitCode == 0) printMenu();
            int ans = inputCheck();
            if (count == 0 && ans > 0 && ans < 6) {
                map = new MyMap();
                initEntity();
                //инициирующие действия
            }
            exitCode = menuSelection(ans);
        }
    }

    private static int inputCheck() {
        int ans;
        while (true) {
            try {
                ans = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод, попробуйте еще раз");
                scan.next();
            }
        }
        return ans;
    }

    private static void printMenu() {
        if (count == 0) System.out.println("╔═══╗╔══╗╔═╗╔═╗╔╗─╔╗╔╗───╔═══╗╔════╗╔══╗╔═══╗╔═╗─╔╗\n" +
                                           "║╔═╗║╚╣─╝║║╚╝║║║║─║║║║───║╔═╗║║╔╗╔╗║╚╣─╝║╔═╗║║║╚╗║║\n" +
                                           "║╚══╗─║║─║╔╗╔╗║║║─║║║║───║║─║║╚╝║║╚╝─║║─║║─║║║╔╗╚╝║\n" +
                                           "╚══╗║─║║─║║║║║║║║─║║║║─╔╗║╚═╝║──║║───║║─║║─║║║║╚╗║║\n" +
                                           "║╚═╝║╔╣─╗║║║║║║║╚═╝║║╚═╝║║╔═╗║──║║──╔╣─╗║╚═╝║║║─║║║\n" +
                                           "╚═══╝╚══╝╚╝╚╝╚╝╚═══╝╚═══╝╚╝─╚╝──╚╝──╚══╝╚═══╝╚╝─╚═╝");
        System.out.println("МЕНЮ:");
        System.out.println("1. Запустить симуляцию на 1 ход");
        System.out.println("2. Запустить симуляцию на 10 ходов");
        System.out.println("3. Ввести количество ходов и запустить симуляцию");
        System.out.println("4. Запустить бесконечную симуляцию");
        System.out.println("5. Начать новую симуляцию");
        System.out.println("6. Выход");
        System.out.println("Введите номер желаемого пункта меню:");
    }

    private static int menuSelection(int ans) {
        int exitCode = 0;
        switch (ans) {
            case 1:
                nextTurn();
                count++;
                break;
            case 2:
                startSimulation(10);
                break;
            case 3:
                int num;
                while (true) {
                    System.out.println("Введите количество ходов:");
                    num = inputCheck();
                    if (num < 1) {
                        System.out.println("Некорректный ввод, попробуйте еще раз");
                    } else {
                        break;
                    }
                }
                startSimulation(num);
                break;
            case 4:
                startSimulation(-1);
            case 5:
                count = 0;
                break;
            case 6:
                exitCode = 1;
                break;
            default:
                System.out.println("Некорректный ввод, попробуйте еще раз");
                exitCode = 2;
        }
        return exitCode;
    }

    private static void startSimulation(int stopNumber) {
        while (true) {
            if (count == stopNumber) {
                if (pauseSimulation()) break;
                stopNumber += stopNumber;
            }
            if (scan.nextLine().equals("e")) {
                break;
            }
            nextTurn();
            count++;
        }
    }

    private static void nextTurn() {
        List<Map.Entry<Position, Entity>> creatures = new ArrayList<>(map.getEntry());

        for (Map.Entry<Position, Entity> entry : creatures) {
            Entity entity = entry.getValue();
            Position oldPos = entry.getKey();

            if (entity instanceof Herbivore || entity instanceof Predator) {
                Creature creature = (Creature) entity;
                Position newPos = creature.makeMove(map, oldPos);
                if (!oldPos.equals(newPos)) {
                    map.removeEntity(oldPos);
                    map.addEntity(newPos, creature);
                }
            }
        }
        fieldRender();
    }


    private static void fieldRender() {
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
    }

    private static void initEntity() {
        map.addEntity(new Position(0, 0), new Herbivore());
        map.addEntity(new Position(49, 0), new Predator());
        for (int i = 0; i < map.getHEIGHT(); i++) {
            if (i != 12) {
                map.addEntity(new Position(25, i), new Rock());
            }
        }
        map.addEntity(new Position(49,24), new Grass());

    }

    private static boolean pauseSimulation() {
        int ans;
        while (true) {
            System.out.println("Симуляция приостановлена.");
            System.out.println("Вы желаете продолжить?");
            System.out.println("1. Да");
            System.out.println("2. Нет");
            System.out.println("Введите номер желаемого пункта меню:");
            ans = inputCheck();
            if (ans == 1) {
                return false;
            } else if (ans == 2) {
                return true;
            } else {
                System.out.println("Некорректный ввод. Введи цифру соответсвующую пункту меню");
            }
        }
    }
}