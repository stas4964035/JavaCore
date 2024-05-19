package ru.geekbrains.core.homework3;

public class Worker extends Person{
    private float fixedMonthSalary;

    public Worker(String name, int age, float fixedMonthSalary) {
        super(name, age);
        this.fixedMonthSalary = fixedMonthSalary;
    }
    private Worker(String name, int age) {
        this(name, age, 0);
    }

    @Override
    protected float countMonthSalary() {
        return fixedMonthSalary;
    }

    @Override
    public String toString() {
        return String.format("%s\nPost: Worker\nMonth Salary: %f\n", super.toString(), countMonthSalary());
    }
}
