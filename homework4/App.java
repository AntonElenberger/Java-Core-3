package ru.geekbrains.antonelenberger.homework4;
import ru.geekbrains.antonelenberger.homework4.task3.*;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Anton Elenberger
 */
public class App {
    private final static Object lock1 = new Object();
    private static volatile char qeueChar = 'A';

    public static void  main(String[] args) {
        printChars(); // Задание первое
        impTask2();   // Задание второе
        Task3.implTask3(); // Задагие третье
    }

    private static void printChars() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    for(int i = 0; i < 5; i++) {
                        synchronized (lock1) {
                            while (qeueChar != 'A') {
                                lock1.wait();
                            }
                            System.out.print('A');
                            qeueChar = 'B';
                            lock1.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    for(int i = 0; i < 5; i++) {
                        synchronized (lock1) {
                            while (qeueChar != 'B') {
                                lock1.wait();
                            }
                            System.out.print('B');
                            qeueChar = 'C';
                            lock1.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    for(int i = 0; i < 5; i++) {
                        synchronized (lock1) {
                            while (qeueChar != 'C') {
                                lock1.wait();
                            }
                            System.out.print('C');
                            qeueChar = 'A';
                            lock1.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private static void impTask2() {
        File textFile = new File("src/text.txt");
        try(FileWriter out = new FileWriter(textFile,true)) {
            Thread[] threads = new Thread[3];
            threads[0] = new Thread(() -> writeToFile(out, "First Thread"));
            threads[1] = new Thread(() -> writeToFile(out, "Second Thread"));
            threads[2] = new Thread(() -> writeToFile(out, "Third Thread"));

            for(Thread t : threads)t.start();
            for(Thread t : threads)t.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void writeToFile(FileWriter writer, String str) {
        try {
            synchronized (writer) {
                for(int i = 0; i < 10; i++) {
                    writer.write(str,0, str.length());
                    Thread.sleep(20);
                }
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
