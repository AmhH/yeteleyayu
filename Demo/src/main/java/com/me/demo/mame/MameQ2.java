package com.me.demo.mame;

public class MameQ2 {

    public static void main(String[] args) {
        System.out.println(answerTwo(new int[]{8,17,18,14,11,20}));
        System.out.println(answerTwo(new int[]{13,14,12,17,10}));
        System.out.println(answerTwo(new int[]{13,14,12,17,10,21}));
        System.out.println(answerTwo(new int[]{8,17,19,14,11,20}));
    }
    public static int answerTwo(int []a) {
        if (a[0] % 2 != a[a.length - 1]%2) {
            System.out.println("first");
            return 0;
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i]%2 != 0 && a[i+1]%2 != 0){
                System.out.println("third: " + a[i] + " " + a[i+1]);
                return 0;
            }
            /*if (a[i+1]%2!=0 && a[i]%2!=0){
                return 0;
            }*/
        }
        return 1;
    }
}
