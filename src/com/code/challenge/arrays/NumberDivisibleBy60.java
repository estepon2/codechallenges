package com.code.challenge.arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberDivisibleBy60 {

    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> remainders = new HashMap<>();
        int count = 0;

        for (int duration : time) {
            int complement = (60 - duration % 60) % 60;
            if (remainders.containsKey(complement)) {
                count += remainders.get(complement);
            }

            int remainder = duration % 60;
            remainders.put(remainder, remainders.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] time1 = {30, 20, 150, 100, 40};
        int[] time2 = {60, 60, 60};

        System.out.println(numPairsDivisibleBy60(time1)); // Output: 3
        System.out.println(numPairsDivisibleBy60(time2)); // Output: 3
    }
}
