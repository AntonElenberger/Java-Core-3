package ru.geekbrains.antonelenberger.homework5;

import ru.geekbrains.antonelenberger.homework5.Stage.*;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Anton Elenberger
 */

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb);
        }

        for (Car car : cars) {
            new Thread(car).start();
        }
    }
}
