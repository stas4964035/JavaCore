package ru.geekbrains.core.homework1.services;

import java.util.LinkedList;

public class Calculator {
    static LinkedList<String> log = new LinkedList<String>();
    static int result;
    public static int start(int b, char operation){
        return start(result, b, operation);
    }
    public static int start(int a, int b, char operation) {
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                result = 0;
        }
        log.add(String.format("%d %c %d = %d", a, operation, b, result));
        return result;
    }
    public static LinkedList<String> getLog(){
        return log;
    }
}
