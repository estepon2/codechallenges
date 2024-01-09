package com.code.challenge.strings;

import org.assertj.core.api.Assertions;

import java.util.HashSet;
import java.util.Set;

public class GenerateDocument {

    public static void main(String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        boolean expected = true;
        boolean actual = generateDocumentTwo(characters, document);
        Assertions.assertThat(expected == actual);
    }

    /**
     * runs in Big 0(m + (n + m) time and Big O(1) space
     * @param characters
     * @param document
     * @return
     */
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

    /**
     * runs in Big O(c(stands for uniques character * (n+m)) time Big O(1) space
     * @param characters
     * @param document
     * @return
     */
    public static boolean generateDocumentTwo(String characters, String document) {
        // Write your code here.
        for(int i=0; i < document.length(); i++) {
            Set<Character> counted = new HashSet<>();
            int charactersCount = 0;
            int documentCount = 0;
            char c = document.charAt(i);
            if(!counted.contains(c)) {
                counted.add(c);

                for(int j =0; j < characters.length(); j++) {
                    if(characters.charAt(j) == c)
                        charactersCount++;
                }

                for(int k =0; k < document.length(); k++) {
                    if(document.charAt(k) == c)
                        documentCount++;
                }
            }

            if(charactersCount < documentCount)
                return false;

        }
        return true;
    }
}
