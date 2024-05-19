package ru.geekbrains.core.lesson3.sample1;

public class Product {
    private String name;
    private static int counter;

    public Product() {
        name = String.format("Product #%d", ++counter);
    }

    public String getName() {
        return name;
    }
}
