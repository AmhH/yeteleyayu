package com.me.demo.preparation;

import java.util.ArrayList;
import java.util.HashSet;

public class Dog {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        Dog aDog = new Dog("Max");
        Dog oldDog = aDog;

        foo(aDog);
        // when foo(...) returns, the name of the dog has been changed to "Fifi"
        aDog.getName().equals("Fifi"); // true
        // but it is still the same dog:
        System.out.println(aDog == oldDog); // true
        System.out.println(aDog.equals(oldDog)); // true
    }

    public static void foo(Dog d) {
        d.getName().equals("Max"); // true
        // this changes the name of d to be "Fifi"
        d.setName("Fifi");
    }
}
