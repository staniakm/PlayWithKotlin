package org.mariusz;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> humans  = new ArrayList<>();
        humans.add(new Person("",",",1, null));
        humans.add(new Student("",",",1, null));

        for (Human h: humans){
            if(h instanceof Person){
                System.out.println("person");
            }
            if (h instanceof Student){
                System.out.println("Stundet" +
                        "");
            }
        }

    }
}
