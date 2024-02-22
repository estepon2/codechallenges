package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraverse {

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}
        };
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
        List<Integer> actual = spiralTraverse(input);

        Assertions.assertThat(expected).isEqualTo(actual);
    }

    // Runs in Big O(n) time and Big O(n) space
    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int startColumn = 0;
        int endRow = array.length-1;
        int endColumn = array[0].length-1;

        while(startRow <= endRow && startColumn <= endColumn ){
            for(int col = startColumn; col <= endColumn; col++)
                result.add(array[startRow][col]);

            for(int row = startRow +1; row <= endRow; row++)
                result.add(array[row][endColumn]);

            for(int col = endColumn-1; col >= startColumn; col--)
                result.add(array[endColumn][col]);

            for(int row = endRow-1; row > startRow; row--)
                result.add(array[row][startColumn]);

            startRow++;
            endRow--;
            startColumn++;
            endColumn--;
        }

        return result;
    }
}
