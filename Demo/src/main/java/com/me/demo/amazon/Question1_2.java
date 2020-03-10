package com.me.demo.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Question1_2 {

    public  List<String> orderedJunctionBoxes(int numberOfBoxes,
                                             List<String> boxList){

        List<String> newVersions = boxList.stream()
                .filter(str -> checkIfNumeric(str.split("\\s")[1]))
                .collect(Collectors.toList());

        boxList.removeAll(newVersions);
        boxList.sort(Comparator.comparing(this::getVersion).thenComparing(this::firstPart));

        boxList.addAll(newVersions);

        return boxList;
    }

    private String firstPart(String str) {
        String substring = str.substring(0, str.indexOf(" "));
        System.out.println(substring);
        return substring;
    }

    private String getVersion(String str) {

        return str.substring(str.indexOf(" "));
    }

    private  boolean checkIfNumeric(String str){
        return  str.matches("-?\\d+(\\.\\d+)?");
    }
    public static void main(String[] args) {

        /*List<String> list = new ArrayList<>();
        list.addAll(List.of("ykc 82 01", "eo first qpx", "09z cat hamster", "06f 12 25 6", "az0 first qpx", "236 cat dog rabbit snake"));*/

        List<String> list = new ArrayList<>();
        list.addAll(List.of("ykc 82 01", "eo first qpx", "06f 12 25 6", "az0 first qpx", "236 cat hamster", "09z cat hamster"));

        System.out.println(new Question1_2().orderedJunctionBoxes(6, list));
    }
}
