package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class ValidSubsequence {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5,1,22,25,6,-1,8,10);
        List<Integer> sequence = Arrays.asList(1,6,-1,10);

        boolean result = isValidSubsequenceTwo(array, sequence);

        Assertions.assertThat(result).isEqualTo(true);
    }
    // it runs in Big O(n) and Big O(1) space
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int sequenceIndex = 0;

        for(int i=0; i < array.size() && sequenceIndex < sequence.size(); i++) {
            if(array.get(i) == sequence.get(sequenceIndex))
                sequenceIndex++;
        }
        return sequenceIndex == sequence.size();
    }

    // it runs in Big O(n) and Big O(1) space
    public static boolean isValidSubsequenceTwo(List<Integer> array, List<Integer> sequence) {
        int arrayIndex = 0;
        int sequenceIndex = 0;

        while(arrayIndex < array.size() && sequenceIndex < sequence.size()) {
            if(array.get(arrayIndex) == sequence.get(sequenceIndex)){
                arrayIndex++;
                sequenceIndex++;
            } else {
                arrayIndex++;
            }
        }

        return sequenceIndex == sequence.size();
    }

}
