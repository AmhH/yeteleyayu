package com.me.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestThings {

    @Test
    public void flattenListOfStringSeparatedByComa(){
        List<String> listOfStr = List.of("A, B, C", "D, E, F", "G, H, U");

        List<String> collect = listOfStr.stream()
                .map(s -> s.split(", "))
                .flatMap(s -> Arrays.stream(s))
                .collect(Collectors.toList());
        System.out.println(collect);

        assertArrayEquals(new String[]{"A","B","C","D","E","F","G","H","U"}, collect.toArray());

    }
}
