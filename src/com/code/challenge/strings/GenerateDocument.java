package com.code.challenge.strings;

import org.assertj.core.api.Assertions;

public class GenerateDocument {

    public static void main(String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        boolean expected = true;
        boolean actual = generateDocument(characters, document);
        Assertions.assertThat(expected == actual);
    }

    public static boolean generateDocument(String characters, String document) {
        // Write your code here.
        for (int i = 0; i < document.length(); i++) {
            int countInDocument = 0;
            int countInCharacters = 0;
            char c = document.charAt(i);
            for(int j = 0; j < document.length(); j++) {
                if(document.charAt(j) == c)
                    countInDocument++;
            }
            for(int k = 0; k < characters.length(); k++) {
                if(characters.charAt(k) == c)
                    countInCharacters++;
            }
            if(countInCharacters < countInDocument )
                return false;
        }
        return true;
    }
}
