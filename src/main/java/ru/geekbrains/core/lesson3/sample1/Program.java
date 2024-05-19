package ru.geekbrains.core.lesson3.sample1;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new ConcreteProduct1());
        products.add(new ConcreteProduct2());
        products.add(new ConcreteProduct3());
        processProducts(products);
    }

    static void processProducts(ArrayList<Product> products) {
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }
}
