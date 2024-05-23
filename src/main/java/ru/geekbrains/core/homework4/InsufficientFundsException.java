package ru.geekbrains.core.homework4;

public class InsufficientFundsException extends Exception{

    public InsufficientFundsException(double balance) {
        super("Недостаточно средств\nТекущий баланс:".concat(String.valueOf(balance)));
    }
}
