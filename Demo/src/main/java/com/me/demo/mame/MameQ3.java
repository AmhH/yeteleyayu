package com.me.demo.mame;

public class MameQ3 {

    public static void main(String[] args) {
        System.out.println(answerThree(new int[]{1,2,3,1,2,3}));
        System.out.println(answerThree(new int[]{1,2,1,2,3}));
        System.out.println(answerThree(new int[]{12,23,3,32}));
        System.out.println(answerThree(new int[]{0}));
        System.out.println(answerThree(new int[]{6,9,0,13}));

    }

    public static int answerThree(int[]a){
        if (a.length%2!=0){
            return 0;
        }
        int sumFirstHalf=0;
        int sumSecondHalf=0;
        for (int i=0; i<a.length/2; i++){
            sumFirstHalf=sumFirstHalf+a[i];
        }
        for (int i=a.length/2; i<a.length; i++){
            sumSecondHalf=sumSecondHalf+a[i];
        }
        if (sumFirstHalf!=sumSecondHalf){
            return 0;
        }
        return 1;
    }

}
