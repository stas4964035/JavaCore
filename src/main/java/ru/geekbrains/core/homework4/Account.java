package ru.geekbrains.core.homework4;

public class Account {
    private static byte counter = 0;
    private double balance;
    private byte id;

    private Account(double balance) {
        this.balance = balance;
        this.id = ++counter;
    }

    public static Account Create(double balance) throws IllegalArgumentException {
        if(balance > 0) return new Account(balance);
        else throw new IllegalArgumentException("Нельзя создать счет с отрицательным балансом!");
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if(amount > 0) balance += amount;
        else throw new IllegalArgumentException("Нельзя внести отрицательное число на счет!");
    }
    public void withdraw(double amount) throws InsufficientFundsException, IllegalArgumentException {
        if(amount < 0) throw new IllegalArgumentException("Нельзя снять отрицательное число со счета!");
        if(amount > balance) throw new InsufficientFundsException(balance);
        else balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Account #%d: %.2f", id, balance);
    }
}
