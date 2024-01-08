package com.code.challenge.arrays;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] output = twoNumberSumThree(new int[]{3,5,-4,8,11,1,-1,6},10);

        Assertions.assertThat(output.length).isEqualTo(2);
        Assertions.assertThat(output).contains(-1);
        Assertions.assertThat(output).contains(11);
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        for(int i=0; i < array.length; i++) {
            for(int j=i+1; j < array.length; j++){
                if(array[i] + array[j] == targetSum) {
                    return new int[]{array[i],array[j]};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSumTwo(int[] array, int targetSum) {
        // x+y = tagteSum that can be simplefied to y = targetSum - x
        Set<Integer> numberFound = new HashSet<>();
        for(int i= 0; i < array.length; i++) {
            int y = targetSum - array[i];
            if(numberFound.contains(y))
                return new int[]{array[i],y};
            else
                numberFound.add(array[i]);
        }
        return new int[0];
    }

    public static int[] twoNumberSumThree(int[] array, int targetSum) {
        Arrays.sort(array);
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while(leftIndex < rightIndex) {
            int sum = array[leftIndex] + array[rightIndex];
            if(sum == targetSum)
                return new int[]{array[leftIndex]+array[rightIndex]};
            if(sum < targetSum)
                leftIndex--;
            if(sum > targetSum)
                rightIndex++;
        }
        return new int[0];
    }
}
