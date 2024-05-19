package ru.geekbrains.core.homework3;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Person p1 = new Freelancer("Petr", 20, 14);
        Person p2 = new Worker("Ivan", 21, 140);


        ArrayList<Person> people = new ArrayList<>();

        people.add(p1);
        people.add(p2);

        for (Person p : people) {
            System.out.printf(p.toString());
        }


    }
}
