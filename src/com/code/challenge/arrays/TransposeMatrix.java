package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] expected = new int[][]{{1,4,7},{2,5,8},{3,6,9}};

        int[][] result = transposeMatrix(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    public static int[][] transposeMatrix(int[][] matrix) {

        int colums = matrix.length;
        int rows = matrix[0].length;
        int i = 0;

        int[][] transposedArray = new int[colums][rows];

        while(i < colums ){
            int j=0;
             while(j < rows){
                 transposedArray[j][i] = matrix[i][j];
                 j++;
             }
             i++;
        }
        return transposedArray;
    }
}
