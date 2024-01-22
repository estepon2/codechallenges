package com.code.challenge.strings;

import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String input = "abcdcaf";
        int expected = 1;
        int result = firstNonRepeatingCharacterTwo(input);

        Assertions.assertThat(expected).isEqualTo(result);
    }

    // Big O(n2) time Big O(1) space
    public static int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        for(int i= 0; i< string.length(); i ++) {
            boolean duplicate = false;
            for(int j=0; j < string.length(); j++) {
                if(string.charAt(i) == string.charAt(j) && i != j)
                    duplicate = true;
            }
            if(!duplicate)
                return i;
        }
        return -1;
    }

    // Big O(26) -> 0(1)
    public static int firstNonRepeatingCharacterTwo(String string) {
        // Write your code here.
        Map<Character,Integer> charactersCount = new HashMap<>();

        for(int i=0; i < string.length(); i ++) {
            char c = string.charAt(i);
            if(charactersCount.containsKey(c)) {
                int ins = charactersCount.get(c);
                charactersCount.put(c,ins+1);
            } else {
                charactersCount.put(c,1);
            }
        }

        for(int j =0; j < string.length(); j++) {
            char c = string.charAt(j);
            int frequency = charactersCount.get(c);
            if(frequency == 1)
                return j;
        }

        return -1;
    }
}
