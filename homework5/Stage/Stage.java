package ru.geekbrains.antonelenberger.homework5.Stage;

import ru.geekbrains.antonelenberger.homework5.Car;

public abstract class Stage {
    int length;
    String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}

