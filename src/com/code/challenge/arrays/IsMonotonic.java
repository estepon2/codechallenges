package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

public class IsMonotonic {

    public static void main(String[] args) {
        int[] array = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        boolean expected = true;

        boolean output = isMonotonic(array);

        Assertions.assertThat(output).isEqualTo(expected);
    }

    // Runs in Big O(n) time and Big O(1) space
    private static boolean isMonotonic(int[] array) {
        boolean increasing = false;
        boolean decreasing = false;

        for(int i =0; i<array.length-1; i++){
            if(array[i] < array[i+1])
                increasing = true;

            if(array[i] > array[i+1])
                decreasing = true;

            if(increasing && decreasing)
                return false;

        }
        return true;
    }
}
