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

import Actions.Action;
import Actions.initActions.PlacePreds;
import Actions.initActions.PlaceGrass;
import Actions.initActions.PlaceHerbs;
import Actions.initActions.PlaceObjects;
import Actions.turnActions.AddPreds;
import Actions.turnActions.AddGrass;
import Actions.turnActions.AddHerbs;
import Actions.turnActions.MoveAction;
import Objects.*;

import java.util.*;

public class Simulation {
    private static int count = 0;
    private static final Scanner scan = new Scanner(System.in);
    private static MyMap map;
    private static final List<Action> turnActions = new ArrayList<>();
    public static void main(String[] args) {
        int exitCode = 0;
        while (exitCode != 1) {
            if (exitCode == 0) printMenu();
            int ans = inputCheck();
            if (count == 0 && ans > 0 && ans < 6) {
                map = new MyMap();
                List<Action> initActions = new ArrayList<>();
                initialize(initActions, turnActions);
                for(Action act : initActions) {
                    act.operation(map);
                }
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
        if (count == 0) System.out.println("""
                ╔═══╗╔══╗╔═╗╔═╗╔╗─╔╗╔╗───╔═══╗╔════╗╔══╗╔═══╗╔═╗─╔╗
                ║╔═╗║╚╣─╝║║╚╝║║║║─║║║║───║╔═╗║║╔╗╔╗║╚╣─╝║╔═╗║║║╚╗║║
                ║╚══╗─║║─║╔╗╔╗║║║─║║║║───║║─║║╚╝║║╚╝─║║─║║─║║║╔╗╚╝║
                ╚══╗║─║║─║║║║║║║║─║║║║─╔╗║╚═╝║──║║───║║─║║─║║║║╚╗║║
                ║╚═╝║╔╣─╗║║║║║║║╚═╝║║╚═╝║║╔═╗║──║║──╔╣─╗║╚═╝║║║─║║║
                ╚═══╝╚══╝╚╝╚╝╚╝╚═══╝╚═══╝╚╝─╚╝──╚╝──╚══╝╚═══╝╚╝─╚═╝""");
        System.out.println("МЕНЮ:");
        System.out.println("1. Запустить симуляцию на 1 ход");
        System.out.println("2. Запустить симуляцию на 50 ходов");
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
                startSimulation(50);
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
            nextTurn();
            count++;
        }
    }

    private static void nextTurn() {
        for(Action act : turnActions) {
            act.operation(map);
        }
//        fieldRender();
    }

    public static void fieldRender(int moveNum) {
        for (int i = -1; i <= map.getHEIGHT(); i++) {
            for (int j = -1; j <= map.getWIDTH(); j++) {
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
        System.out.println("______________\n|Round||Move |   Herbivores left: " + map.getHerbsCount());
                System.out.printf("|%-5d||%-5d|   Predators left: %d", count, moveNum, map.getPredsCount());
    }

    private static boolean pauseSimulation() {
        int ans;
        while (true) {
            System.out.println("Симуляция приостановлена.");
            System.out.println("Вы желаете продолжить?");
            System.out.println("1. Да");
            System.out.println("2. Нет");
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

    private static void initialize(List<Action> initActions, List<Action> turnActions) {
        initActions.add(new PlaceGrass());
        initActions.add(new PlaceHerbs());
        initActions.add(new PlaceObjects());
        initActions.add(new PlacePreds());
        turnActions.add(new MoveAction());
        turnActions.add(new AddHerbs());
        turnActions.add(new AddGrass());
        turnActions.add(new AddPreds());
    }
}