package ru.geekbrains.antonelenberger.homework4.task3;

public class MFU {
    final static Object printPages = new Object();
    final static Object scanPages = new Object();
    public static void print(int pages) {
        for(int i = 1; i <= pages; i++) {
            System.out.println("Page " + i + " printed");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Printing is complete\n");
    }

    public static void scan(int pages) {
        for(int i = 1; i <= pages; i++) {
            System.out.println("Page " + i + " scanned");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Scanning is complete\n");
    }
}
