package ru.geekbrains.core.lesson3;

public class Program {
    public static void main(String[] args) {
        try {
//            Human human1 = new Human(null, -200);
              BaseHuman human2 = Human.create("user", 27, 100, 10);
              human2.printDisplayInfo();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
