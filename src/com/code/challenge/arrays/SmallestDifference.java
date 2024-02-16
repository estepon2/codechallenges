package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {

        int[] arrayOne = new int[]{-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = new int[]{26, 134, 135, 15, 17};

        int [] expected = new int[]{28,26};

        int [] result = smallestDifference(arrayOne, arrayTwo);

        Assertions.assertThat(result).isEqualTo(expected);

    }

    // runs in Big O(nlog(n) + nlog(m)) time, Big O(1) space
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int[] pair = new int[2];

        int arrayOneIndex = 0;
        int arrayTwoIndex = 0;
        int smallestDiff = Integer.MIN_VALUE;

        while(arrayOneIndex < arrayOne.length && arrayTwoIndex < arrayTwo.length){
            int diff = Math.abs(arrayOne[arrayOneIndex] - arrayTwo[arrayTwoIndex]);

            if(diff < smallestDiff){
                pair = new int[]{arrayOne[arrayOneIndex], arrayTwo[arrayTwoIndex]};
                smallestDiff = diff;
                arrayOneIndex++;
                arrayTwoIndex++;
            }

            if(arrayOne[arrayOneIndex] < arrayTwo[arrayTwoIndex])
                arrayOneIndex++;
            else
                arrayTwoIndex++;

        }

        return pair;
    }
}
