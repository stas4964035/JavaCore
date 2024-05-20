package ru.geekbrains.core.homework3;

public class Worker extends Person {


    public Worker(String name, int age) {
        super(name, age);
    }

    public Worker(String name, int age, float salary) {
        this(name, age);
        setMonthSalary(salary);
    }

    @Override
    protected void countMonthSalary() {
        setMonthSalary(getMonthSalary());
    }




    @Override
    public String toString() {
        return String.format("%s\nPost: Worker\nMonth Salary: %f\n", super.toString(), getMonthSalary());
    }
}
