package ru.geekbrains.core.homework3;

public abstract class Person<T> implements Comparable<T> {
    protected byte personID;
    protected String name;
    protected int age;
    private static byte count;

    protected Person(String name, int age) {
        count++;
        this.name = name;
        this.age = age;
        personID = count;
    }

    public String getName() {
        return name;
    }

    protected int getAge() {
        return age;
    }

    protected byte getPersonID() {
        return personID;
    }

    protected abstract float countMonthSalary();



    @Override
    public String toString() {
        return String.format("Person ID: %d, Name: %s, Age: %d", personID, name, age);
    }
}
