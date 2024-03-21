package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

public class FirstDuplicateValue {

    public static void main(String[] args) {
        int[] input = new int[]{2,1,5,2,3,3,4};
        int expected = 2;

        int actual = firstDuplicateValue(input);

        Assertions.assertThat(expected).isEqualTo(actual);
    }

    // Big O(n2) time and Big(1) space
    public static int firstDuplicateValue(int[] array) {
        int minimumValue = array.length;

        for(int i = 0; i < array.length; i ++) {
            int value = array[i];
            for(int j= i + 1; j < array.length; j ++) {
                int valueToCompare = array[j];
                if(value == valueToCompare) {
                    minimumValue = Math.min(minimumValue, j);
                }
            }
        }

        if( minimumValue == array.length)
            return -1;
        else
            return array[minimumValue];
    }
}
