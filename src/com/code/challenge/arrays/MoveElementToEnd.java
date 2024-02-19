package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2,1,2,2,2,3,4,2);
        int toMove = 2;
        List<Integer> expectedStart = Arrays.asList(1,3,4);
        List<Integer> expectedEnd = Arrays.asList(2,2,2,2,2);

        List<Integer> expected = Arrays.asList(4,1,3,2,2,2,2,2);

        List<Integer> result = moveElementToEnd(array, toMove);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    // Run in Big O (n) time and Big O(1) space
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int i = 0;
        int j = array.size() - 1;

        while(i < j) {
            while(i < j && array.get(j) == toMove) j--;

            if(array.get(i) == toMove) {
                int temp = array.get(j);
                array.set(j, array.get(i));
                array.set(i, temp);
            }

            i++;
        }
        return array;
    }
}
