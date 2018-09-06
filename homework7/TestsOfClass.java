package ru.geekbrains.antonelenberger.homework7;

public class TestsOfClass {
    @BeforeSuit
    static void prepareTest() {
        System.out.println("Preparation of tests");
    }

    @Test(priority = 8)
    static void test1() {
        System.out.println("First test is running");
    }

    @Test(priority = 5)
    static void test2() {
        System.out.println("Second test is running");
    }

    @Test(priority = 2)
    static void test3() {
        System.out.println("Third test is running");
    }

    @Test(priority = 10)
    static void test5() {
        System.out.println("Fifth test is running");
    }

    @AfterSuit
    static void ending() {
        System.out.println("Tests is ended");
    }
}
