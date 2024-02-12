package com.code.challenge.strings;

import org.assertj.core.api.Assertions;

public class PalindromeCheck {

    public static void main(String[] args) {
        String string = "abcdcba";
        boolean result = isPalindromeTwoPointer(string);

        Assertions.assertThat(result).isEqualTo(true);
    }

    // runs in Big O(n) time and Big(O) space
    public static boolean isPalindrome(String str) {

        StringBuilder sb = new StringBuilder();

        for(int i= str.length()-1; i >=0; i--)
            sb.append(str.charAt(i));

        return str.equals(sb.toString());
    }

    // runs in Big O(n) time and Big O(n) space because of recursion
    public static boolean isPalindromeRecursion(String str) {
        if(str.length() == 1 || str.length() == 0)
            return true;
        return str.charAt(0) == str.charAt(str.length()-1) &&
                isPalindromeRecursion(str.substring(1,str.length()-1));
    }

    // runs in Big 0(n) time and Big 0(1) space
    public static boolean isPalindromeTwoPointer(String str) {

        int leftPointer = 0;
        int rightPointer = str.length()-1;

        while(leftPointer<rightPointer){

            if(str.charAt(leftPointer) != str.charAt(rightPointer))
                return false;

            leftPointer++;
            rightPointer--;
        }

        return true;
    }
}
