package ru.geekbrains.core.homework3;

import java.util.*;

public class Program {
    public static void main(String[] args) {


        Staff staff = new Staff();


        staff.add(new Freelancer("Petr", 20, 14));
        staff.add(new Worker("Ivan", 21, 1400));
        staff.add(new Freelancer("Denis", 20, 12));
        staff.add(new Worker("Jeka", 21, 1500));
        staff.add(new Freelancer("Vadim", 20, 15));
        staff.add(new Worker("Slavik", 21, 1430));
        staff.add(new Freelancer("Miha", 20, 11));
        staff.add(new Worker("Oleg", 21, 1490));
        staff.sort();
        for (Person p : staff) {
            System.out.println(p.toString());
        }


    }
}
