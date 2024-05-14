package ru.geekbrains.core.homework1.utils;

import java.util.LinkedList;

public class Decorator {
    public static String view(int result){
        return Integer.toString(result);
    }
    public static String view(LinkedList<String> log){
        StringBuilder res = new StringBuilder();
        for (String s: log){
            res.append(s).append('\n');
        }
        return res.toString();
    }
}
