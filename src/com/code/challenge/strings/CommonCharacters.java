package com.code.challenge.strings;

import org.assertj.core.api.Assertions;

import java.util.*;

public class CommonCharacters {

    public static void main(String[] args) {
        String [] input = new String[]{"abc", "bcd", "cbad"};
        String [] output = new String[]{"b", "c"};

        String [] result = commonCharacters(input);

        Assertions.assertThat(output).isEqualTo(result);
    }


    // runs in Big O (n * m) time and Big O (c) total number of unique characters in
    // character count
    public static String[] commonCharacters(String[] strings) {
        Map<Character, Integer> characterCount = new HashMap<>();
        List<String> finalCharacter = new ArrayList<>();

        for(int i= 0; i < strings.length; i++) {
            Set<Character> uniqueCharacters = new HashSet<>();
            for(char c: strings[i].toCharArray()) {
                if(!uniqueCharacters.contains(c)) {
                    int count = characterCount.get(c) != null ? characterCount.get(c)+1 : 1;
                    characterCount.put(c,count);
                }
                uniqueCharacters.add(c);
            }
        }
        for(Map.Entry<Character, Integer> entry: characterCount.entrySet()) {
            if(entry.getValue() >= strings.length)
                finalCharacter.add(entry.getKey().toString());
        }

        return finalCharacter.toArray(new String[finalCharacter.size()]);
    }
}
