package com.me.demo.mame;

public class MameQ1 {

    public static void main(String[] args) {
        System.out.println(getSequence(4));
        System.out.println(getSequence(5));
        System.out.println(getSequence(6));

        //

        System.out.println(getSequenceRecursion(4));
        System.out.println(getSequenceRecursion(5));
        System.out.println(getSequenceRecursion(6));

        //
        System.out.println(answerOne(4));
        System.out.println(answerOne(5));
        System.out.println(answerOne(6));
    }

    public static int getSequence(int n){
        int[] temp = new int[n];
        temp[0] = 1;
        temp[1] = 2;
        for (int i = 3; i < n; i++) {
            temp[i] = temp[i-1] * temp[i-2] - temp[i-3];
        }
        temp[2] = 3;
        return temp[n-1];
    }

    public static int getSequenceRecursion(int n){
        if(n == 1 || n == 2 || n == 3)
            return n;
        return getSequenceRecursion(n-1) * getSequenceRecursion(n-2) - getSequenceRecursion(n-3);
    }

    public static int answerOne(int n){
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        for (int i=3; i<Integer.MAX_VALUE; i++) {
            System.out.println("##########: " + i);
            int[] temp = new int[]{1, 2, 3};
            temp[i] = temp[i - 1] * temp[i - 2] - temp[i - 3];

            return temp[i];
        }

        return 0;
    }

}
