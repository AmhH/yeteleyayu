package com.me.demo.amazon;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<MyClass> list = null;
        list.sort(Comparator.comparing(MyClass::getString).thenComparing(MyClass::getDate));
    }
}
