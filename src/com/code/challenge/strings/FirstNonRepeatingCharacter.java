package com.code.challenge.strings;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {

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
}
