package ru.geekbrains.antonelenberger.homework4.task3;


public class Task3 {
    static MFU mfu = new MFU();
    public static void implTask3() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mfu.printPages) {
                    mfu.print(5);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mfu.scanPages) {
                    mfu.scan(15);
                }
            }
        });
        t1.start();
        t2.start();

    }
}
