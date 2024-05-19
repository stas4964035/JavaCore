package ru.geekbrains.core.lesson3;

public class Human extends BaseHuman implements Runner {


    private int maxRun;
    private int maxJump;

    private  Human(String name, int age, int maxRun, int maxJump) {
        super(name, age);
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }
    public static Human create(String name, int age, int maxRun, int maxJump) {
        if (age < 18) {
            throw new RuntimeException("Не правильный возраст!");
        }
        if (name == null) {
            throw new RuntimeException("Не правильное имя!");
        }
        return new Human(name, age, maxRun, maxJump);

    }

    @Override
    public void printDisplayInfo() {
        System.out.printf("%s %d\n", name, age);
    }

    @Override
    public boolean jump(int height) {
        if(height > maxJump) return false;
        return true;
    }

    @Override
    public boolean run(int length) {
        if (length > maxRun) return false;
        return true;
    }
}
