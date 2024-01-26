package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

import java.util.Arrays;

public class SortedSquaredArray {

    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 3, 5, 6, 8, 9};
        int[] expected = new int[] {1, 4, 9, 25, 36, 64, 81};
        int[] actual = sortedSquaredArray(input);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertThat(expected[i]).isEqualTo(actual[i]);
        }
    }

    // Big O (n log n) because java sort implementation sort method
    public static int[] sortedSquaredArray(int[] array) {
        int[] squaredArray = new int[array.length];

        for(int i=0; i < array.length; i++ ) {
            squaredArray[i] = array[i] * array[i];
        }

        Arrays.sort(squaredArray);

        return squaredArray;
    }
}
