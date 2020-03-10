package com.me.demo.google;

import java.util.Arrays;

/**
 * You have two arrays source and target, containing two permutations of the numbers [0..n-1]. You would like to
 * rearrange source so that it equals to target. The only allowed operations is “swap a number with 0”.
 * Find the minimum number of swaps?
 *
 * e.g. {1,0,2,3} -> {1,3,2,0} swap 0 with 3. one swap is enough.
 */
public class Solution {

    public static void main(String[] args) {
        int[] source = {2, 3, 4, 1, 0};
        int[] target = {3, 0, 4, 2, 1};
        transform(source, target);

    }

    public static void transform(int[] source, int[] target){
        if(source.length != target.length){
            System.out.println("Both arrays needs to be same size");
            return;
        }

        int indexOfZero = getIndex(source, 0);
        for(int i = 0; i < source.length; i++){
            swap(source, indexOfZero, i);
            indexOfZero = i;
            int elementIndex = getIndex(source, target[i]);
            swap(source, indexOfZero, elementIndex);
        }
        System.out.println(Arrays.toString(source));
    }

    private static void swap(int[] source, int indexOfZero, int elementIndex) {
        int temp = source[elementIndex];
        source[elementIndex] = source[indexOfZero];
        source[indexOfZero] = temp;
        System.out.println("Swapping element at index: " + elementIndex + " with: " + indexOfZero);
    }

    private static int getIndex(int[] source, int element) {
        for(int i = 0; i < source.length; i++){
            if(source[i] == element)
                return i;
        }

        return 0;
    }
}
