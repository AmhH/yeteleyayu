package com.me.demo.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Question1 {

    public static List<String> orderedJunctionBoxes(int numberOfBoxes,
                                             List<String> boxList){


        Comparator<String> comparator = (str1, str2) -> {
            String version1 = str1.split(" ")[1];
            String version2 = str2.split(" ")[1];
            if(checkIfNumeric(version1) && checkIfNumeric(version2))
                return 0;

            if(!checkIfNumeric(version1) && checkIfNumeric(version2))
                return 1;

            if(!checkIfNumeric(version1) && !checkIfNumeric(version2))
                return version1.compareTo(version2);

            if(checkIfNumeric(version1) && !checkIfNumeric(version2))
                return -1;


            return 0;
        };

        boxList.sort(comparator);

        return boxList;

    }

    public static boolean checkIfNumeric(String str){
        return  str.matches("-?\\d+(\\.\\d+)?");
    }
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.addAll(List.of("ykc 82 01", "eo first qpx", "09z cat hamster", "06f 12 25 6", "az0 first qpx", "236 cat dog rabbit snake"));

        System.out.println(orderedJunctionBoxes(6, list));
    }
}
