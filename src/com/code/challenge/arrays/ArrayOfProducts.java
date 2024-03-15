package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

public interface ArrayOfProducts {

    public static void main(String[] args) {
        int[] input = new int[]{5, 1, 4, 2};
        int[] expected = new int[]{8,40,10,20};

        int[] output = arrayOfProductsTwo(input);

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

    // runs in Big O(n) time and Big O(n) space
    static public int[] arrayOfProductsTwo(int[] array) {

        int[] products = new int[array.length];
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];

        int leftRunningProduct = 1;
        for( int i = 0; i < array.length; i++){
            leftProducts[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct = 1;
        for(int i = array.length -1; i >=0; i--){
            rightProducts[i] = rightRunningProduct;
            rightRunningProduct *= array[i];
        }

        for(int i = 0; i < array.length; i ++){
            products[i] = leftProducts[i] * rightProducts[i];
        }
        return products;
    }
}
