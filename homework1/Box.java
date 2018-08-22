package ru.geekbrains.antonelenberger.homework1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit>  {
    public List<T> boxOfFruits = new ArrayList<>();
    public void addFruitToBox(T fruit) {
        boxOfFruits.add(fruit);
    }
    public void toAnotherBox(Box<T> anotherBox) {
        for(T fruit : boxOfFruits){
            anotherBox.addFruitToBox(fruit);
        }
        boxOfFruits.clear();
    }
    public boolean Compare(Box<?> anotherBox) {
        return ((Double) this.getWeight()).equals(anotherBox.getWeight());
    }
    public double getWeight(){
        double sum = 0.0;
        for (T fruit : boxOfFruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }
}
