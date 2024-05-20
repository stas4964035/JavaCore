package ru.geekbrains.core.homework3;

public abstract class Person implements Comparable<Person> {
    private static byte count;
    protected byte personID;
    protected String name;
    protected int age;
    private float monthSalary;

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

    protected abstract void countMonthSalary();

    @Override
    public int compareTo(Person o) {
        int result = (int) (this.getMonthSalary() - o.getMonthSalary());
        if (result == 0) {
            result = this.getName().compareTo(o.getName());
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("Person ID: %d\nName: %s, Age: %d", personID, name, age);
    }

    public float getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(float monthSalary) {
        this.monthSalary = monthSalary;
    }
}
