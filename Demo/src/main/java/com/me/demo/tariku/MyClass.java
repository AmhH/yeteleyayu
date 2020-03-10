package com.me.demo.tariku;

import java.util.ArrayList;
import java.util.List;

public class MyClass {

    public static void foo(int i){
        System.out.println("Single var method called");
    }

    public static void foo(List<Integer> l){
        System.out.println("List method called");
    }

    public static void foo(int... i){
        System.out.println("Var arg method called");
    }

    public static void main(String[] args) {
        foo(0);
        foo(0, 1, 2);
        foo(new int[]{});
        foo(new ArrayList<>());
    }
}
