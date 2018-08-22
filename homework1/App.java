package ru.geekbrains.antonelenberger.homework1;
/**
 * @author Anton Elenberger
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Задание номер один поменять местами два элемента масива");
        showChangePlacesOfElements();
        System.out.println("Задание номер два преобразовать массив в ArrayList");
        showEvolutionToArrayList();
        System.out.println("Задание третье");
        task3Implementation();
    }

    public static <T> void changePlacesOfElement(T[] array, int first, int second){
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void showChangePlacesOfElements() {
        String[] arrayToChangeElement = {"1", "34", "Hello", "Basketball"};
        System.out.print("Массив до: ");
        System.out.println(Arrays.toString(arrayToChangeElement));

        changePlacesOfElement(arrayToChangeElement, 1, 2);

        System.out.print("Массив после: ");
        System.out.println(Arrays.toString(arrayToChangeElement));
    }

    public static <T> List<T> changeToArrayList(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }

    public static void  showEvolutionToArrayList(){
        final int SIZE_OF_ARRAY = 8;
        Integer[] arrayToList = new Integer[SIZE_OF_ARRAY];
        for(int i = 0; i < SIZE_OF_ARRAY; i++) {
            arrayToList[i] = i;
        }
        System.out.println("Имеем: " + arrayToList.getClass().getSimpleName());
        System.out.println("Получаем: " + changeToArrayList(arrayToList).getClass().getSimpleName());
    }

    public static void task3Implementation() {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleNewBox = new Box<>();
        appleBox.addFruitToBox(new Apple());
        appleBox.addFruitToBox(new Apple());
        orangeBox.addFruitToBox(new Orange());
        orangeBox.addFruitToBox(new Orange());

        System.out.println("Вес корзинки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес корзинки с апельсинами: " + orangeBox.getWeight());
        System.out.println("-------------------");
        System.out.println("У нас еще есть пустая корзинка весом " + appleNewBox.getWeight() + " пересыпем яблоки туда");

        appleBox.toAnotherBox(appleNewBox);

        System.out.println("Вес теперь уже не пустой козинки " + appleNewBox.getWeight());

        System.out.println("интересно одинаков ли вес апельсинов и яблок");
        if(orangeBox.Compare(appleNewBox)) {
            System.out.println("И правда вес одинаковый");
        } else {
            System.out.println("К сожелению вес разный");
        }
    }





}
