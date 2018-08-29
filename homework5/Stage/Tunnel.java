package ru.geekbrains.antonelenberger.homework5.Stage;

import ru.geekbrains.antonelenberger.homework5.Car;
import ru.geekbrains.antonelenberger.homework5.MainClass;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static final int CAR_PERMIT = MainClass.CARS_COUNT / 2;
    private Semaphore smf = new Semaphore(CAR_PERMIT);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smf.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smf.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
