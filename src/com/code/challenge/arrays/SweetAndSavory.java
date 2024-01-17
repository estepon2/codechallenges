package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SweetAndSavory {

    public static void main(String[] args) {

        int[] dishes = new int[] {-3, -5, 1, 7};
        int target = 8;
        int[] expected = new int[] {-3, 7};

        int[] result = sweetAndSavory(dishes, target);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    // Big O (n) time Big O (n) space
    public static int[] sweetAndSavory(int[] dishes, int target) {
        // separate sweet dishes and savory dishes.

        List<Integer> sweet = new ArrayList<Integer>();
        List<Integer> savory = new ArrayList<Integer>();

        for(int i =0; i < dishes.length; i++) {
            if(dishes[i] < 0)
                sweet.add(dishes[i]);
            else
                savory.add(dishes[i]);
        }
        Collections.sort(sweet, Collections.reverseOrder());
        Collections.sort(savory);
        System.out.println(sweet);
        System.out.println(savory);
        // start initial values
        int sweetIndex = 0;
        int savoryIndex = 0;
        int [] bestAnswer = new int[2];
        int bestDifference = Integer.MIN_VALUE;

        // iterate thorugh sweet dishes we can run into a outofbounds
        // we iterate before the size
        while(sweetIndex < sweet.size() && savoryIndex < savory.size()) {
            int currentSum = sweet.get(sweetIndex) + savory.get(savoryIndex);

            if(currentSum <= target) {
                int currentDifference =  currentSum - target;
                if(currentDifference > bestDifference) {
                    bestDifference = currentDifference;
                    bestAnswer = new int[]{sweet.get(sweetIndex), savory.get(savoryIndex)};
                }
                savoryIndex+=1;
            } else {
                sweetIndex+=1;
            }

        }
        return bestAnswer;
    }
}
