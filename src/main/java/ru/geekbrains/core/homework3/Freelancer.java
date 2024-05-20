package ru.geekbrains.core.homework3;

public class Freelancer extends Person {
    private float hourSalary;

    public Freelancer(String name, int age, float hourSalary) {
        super(name, age);
        this.hourSalary = hourSalary;
        countMonthSalary();
    }
    private Freelancer(String name, int age) {
        this(name, age, 0);
    }

    @Override
    protected void countMonthSalary() {
        setMonthSalary((float) (20.8 * 8 * hourSalary));
    }

    @Override
    public String toString() {
        return String.format("%s\nPost: Freelancer\nMonth Salary: %f\n", super.toString(), getMonthSalary());
    }
}
