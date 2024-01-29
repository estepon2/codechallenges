package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

import java.util.Arrays;

public class SortedSquaredArray {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 5, 6, 8, 9};
        int[] expected = new int[]{1, 4, 9, 25, 36, 64, 81};
        int[] actual = sortedSquaredArrayTwo(input);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertThat(expected[i]).isEqualTo(actual[i]);
        }
    }

    // Big O (n log n) because java sort implementation sort method
    public static int[] sortedSquaredArray(int[] array) {
        int[] squaredArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            squaredArray[i] = array[i] * array[i];
        }

        Arrays.sort(squaredArray);

        return squaredArray;
    }

    //Big O(n) space Big O(n) time
    public static int[] sortedSquaredArrayTwo(int[] array) {
        int[] sortedArray = new int[array.length];
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int indexSortedArray = array.length - 1;

        while (leftIndex <= rightIndex) {
            int absLeft = Math.abs(array[leftIndex]);
            int absRight = Math.abs(array[rightIndex]);
            if (absLeft > absRight) {
                int squaredValue = absLeft * absLeft;
                sortedArray[indexSortedArray] = squaredValue;
                leftIndex++;
                indexSortedArray--;
            } else {
                int squaredValue = absRight * absRight;
                sortedArray[indexSortedArray] = squaredValue;
                rightIndex--;
                indexSortedArray--;

            }
        }
        return sortedArray;
    }
}
