package com.me.demo.preparation;

public class Raya {

    public static void main(String[] args) {
        //System.out.println(areEqualByThreeDecimalPoints(3.1756, 3.175));
        //System.out.println(areEqualByThreeDecimalPoints2(3.1756, 3.175));
        System.out.println(areEqualByThreeDecimalPoints2(3.176, 3.175));
        System.out.println(areEqualByThreeDecimalPoints(-3.1756, -3.175));
        char c = '\u0000';

        System.out.println(c);
    }

    public static boolean areEqualByThreeDecimalPoints(double val1, double val2){
        double newVal1 = Math.floor(Math.abs(val1) * 1000);
        double newVal2 = Math.floor(Math.abs(val2) * 1000);

        return newVal1 == newVal2;
    }

    public static boolean areEqualByThreeDecimalPoints2(double val1, double val2){
        val1 = Math.floor(val1 * 1000);
        val1 = val1/1000d;
        val2 = Math.floor(val2 * 1000);
        val2 = val2/1000d;

        return val1 == val2;
    }
}
