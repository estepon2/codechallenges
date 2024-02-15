package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static void main(String[] args) {
        int[] array = new int[] {12, 3, 1, 2, -6, 5, -8, 6 };
        List<Integer[]> result = threeNumberSum(array,0);
        List<Integer[]> expected = new ArrayList<>(Arrays.asList(
                new Integer[]{-8, 2, 6},
                new Integer[]{-8, 3, 5},
                new Integer[]{-6, 1, 5}
        ));

        Assertions.assertThat(expected).isEqualTo(result);
    }

    // it runs in Big O(n2) time because of the two nested loops
    // O(n) space
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> triplets = new ArrayList<>();
        Arrays.sort(array);

        for(int i = 0; i < array.length-2; i++) {
            int leftIndex = i+1;
            int rightIndex = array.length-1;

            while(leftIndex < rightIndex) {
                int sum = array[i]+array[leftIndex]+array[rightIndex];
                if(sum == targetSum) {
                    triplets.add(new Integer[]{array[i], array[leftIndex], array[rightIndex]});
                    leftIndex++;
                    rightIndex--;
                }
                if(sum < targetSum)
                    leftIndex++;
                if(sum > targetSum)
                    rightIndex--;
            }

        }

        return triplets;
    }
}
