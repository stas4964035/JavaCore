package ru.geekbrains.core.homework4;

public class InsufficientFundsException extends Exception{

    public InsufficientFundsException(double balance) {
        super("\nНедостаточно средств\nТекущий баланс:".concat(String.valueOf(balance)));
    }
}
