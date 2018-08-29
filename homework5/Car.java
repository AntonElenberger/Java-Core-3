package ru.geekbrains.antonelenberger.homework5;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private CyclicBarrier cb;
    private Race race;
    private int speed;
    private String name;
    private static volatile boolean gotWinner = false;
    private static volatile boolean raceStart = false;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    Car(Race race, int speed, CyclicBarrier cb) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();

            if(!raceStart) {
                raceStart = true;
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        if(!gotWinner) {
            gotWinner = true;
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> " + this.name + " выиграл гонку!");
        }

        CARS_COUNT--;
        if(CARS_COUNT == 0) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> гонка завершена");
        }
    }
}
