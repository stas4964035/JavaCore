package ru.geekbrains.core.homework3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



public class Staff implements Iterable<Person> {

    private List<Person> staffList = new ArrayList<Person>();


    public void add(Person person) {
        staffList.add(person);

    }

    public void sort(){
        Collections.sort(staffList);
    }

    @Override
    public Iterator<Person> iterator() {
        return staffList.listIterator();
    }


}
