package ru.geekbrains.core.homework1.task1;

import ru.geekbrains.core.homework1.services.Calculator;
import ru.geekbrains.core.homework1.utils.Decorator;

public class Program {
    public static void main(String[] args) {

        Calculator.start(2, '+');
        Calculator.start(2, '+');
        Calculator.start(2, '+');
        System.out.println(Decorator.view(Calculator.start(4, '/')));
        System.out.println(Decorator.view(Calculator.getLog()));
    }
}
