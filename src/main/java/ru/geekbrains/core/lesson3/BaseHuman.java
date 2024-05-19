package ru.geekbrains.core.lesson3;

public abstract class BaseHuman {
    protected String name;
    protected int age;
//    public BaseHuman(){
//        this("John Doe",18);
//    }
    private BaseHuman(int age){
        this("John Doe",age);
    }
    private BaseHuman(String name){
        this(name,18);
    }
    protected BaseHuman(String name, int age){
        updateName(name);
        updateAge(age);
    }



    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void updateAge(int age){
        if(age < 18){
            throw new RuntimeException("Не правильный возраст!");
        }
        this.age = age;
    }

    private void updateName(String name){
        if(name == null){
            throw new RuntimeException("Не правильное имя!");
        }
        this.name = name;
    }
    public abstract void printDisplayInfo();

}
