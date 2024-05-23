package ru.geekbrains.core.homework4;

public class Program {
    public static void main(String[] args) {


        try {

//            Account a = Account.Create(-200); // Исключение IllegalArgumentException
            Account a1 = Account.Create(200);

//            a1.deposit(-100); // Исключение IllegalArgumentException
            a1.deposit(100);
            a1.withdraw(500); // Исключение InsufficientFundsException
            a1.withdraw(100);
            System.out.println(a1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
