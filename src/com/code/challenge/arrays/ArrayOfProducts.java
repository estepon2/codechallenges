package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

public interface ArrayOfProducts {

    public static void main(String[] args) {
        int[] input = new int[]{5, 1, 4, 2};
        int[] expected = new int[]{8,40,10,20};

        int[] output = arrayOfProducts(input);

        Assertions.assertThat(output).isEqualTo(expected);

    }

    // runs in Big O(n2) time and Big O(n) space
    static public int[] arrayOfProducts(int[] array) {

        int [] products = new int[array.length];

        for(int i= 0; i < array.length; i++) {
            int product = 1;
            for(int j = 0; j < array.length; j++) {
                if(j != i) {
                    product *= array[j];
                }
            }

            products[i] = product;
        }

        return products;
    }
}
