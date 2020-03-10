package com.me.demo.tariku;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> result1 = new ArrayList<>();
        if(A<3){
            return result1;
        }

        boolean isPrime[] = new boolean[A + 1];
        populatePrime(A, isPrime);

        for(int i=2; i<A; i++){
            if(isPrime[i] && isPrime[A-i]){
                result1.add(i);
                result1.add(A-1);
                return result1;
            }
        }
        return result1;
    }

    boolean populatePrime(int A, boolean isPrime[]){
        isPrime[0] = isPrime[1] = false;
        for(int i=2; i<=A; i++){
            isPrime[i] = true;
        }

        for(int p=2; p*p<=A; p++){
            if(isPrime[p] == true){
                for(int i = p*p; i<=A; i+=p){
                    isPrime[i] = false;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        ArrayList<Integer> primesum = solution.primesum(10);
        System.out.println(primesum);
    }
}
