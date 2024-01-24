package com.code.challenge.strings;

import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Semordnilap {

    public static void main(String[] args) {
        String [] input = new String[] {"desserts", "stressed", "hello"};
        List<List<String>> expected = new ArrayList<>();
        List<String> pair = new ArrayList<>();
        pair.add("desserts");
        pair.add("stressed");
        expected.add(pair);

        List<List<String>> actual = semordnilap(input);

        Assertions.assertThat(expected).isEqualTo(actual);
    }

    // Big O(n x m) n the lenght of words array and m the length
    // of the longest word
    public static List<List<String>> semordnilap(String[] words) {
        // Write your code here.
        Set<String> uniqueStrings = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for(int i= 0; i < words.length; i++) {
            uniqueStrings.add(words[i]);
        }

        for(int j=0; j < words.length; j++) {
            String word = words[j];
            String reversedWord = semordnilap(word);
            // check if word is in the set and
            // if the reversed is not the same as word because we would have
            // a palindrome
            if(uniqueStrings.contains(reversedWord) && !reversedWord.equals(word)) {
                List<String> semordnilapair = new ArrayList<>();
                semordnilapair.add(word);
                semordnilapair.add(reversedWord);
                uniqueStrings.remove(word);
                uniqueStrings.remove(reversedWord);
                result.add(semordnilapair);
            }
            uniqueStrings.remove(word);
        }
        return result;
    }

    public static String semordnilap(String word) {
        StringBuilder sb = new StringBuilder();

        for(int i= word.length()-1; i >= 0; i --) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}
