package com.code.challenge.strings;

public class CaesarCypherEncryptor {

    public static void main(String[] args) {
        String expected = "zab";
        String actual = ceaserCypherEncryptor("xyz",2);
    }

    // Big O (n) time Big O(n) space
    public static String ceaserCypherEncryptor(String str, int key) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < str.length(); i++) {
            // wrap around 26 posibble characters
            int ntc =  (int) str.charAt(i) + (key%26);
            // if this is less or equal this means we got lowercase characters
            if(ntc <= 122) {
                sb.append((char) ntc);
            } else {
                // otherwhise we wrap around here 96 the possible charcaters before
                // the first lowercase character 97 and mod of the possible last
                // character 122
                sb.append((char) (96 + (ntc%122)));
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
}
