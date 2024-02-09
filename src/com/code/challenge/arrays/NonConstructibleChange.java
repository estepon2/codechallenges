package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String[] args) {
        int[] input = new int[]{5,7,1,1,2,3,22};
        int expected = 20;

        int result = nonConstructibleChange(input);

        Assertions.assertThat(expected).isEqualTo(result);
    }

    // runs in Big O(n) Big (1) Time
    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);

        int change = 0;
        int sum = 0;

        for(int i =0; i < coins.length; i++) {
            sum = change + 1;
            if(coins[i]>sum)
                return sum;
            else
                change+=coins[i];
        }
        return change+1;
    }
}
