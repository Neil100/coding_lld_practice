package com.example.coding;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] alphabets = new int[52];
        Character ch;
        for(int i=0; i<s.length(); i++) {
            ch = s.charAt(i);
            if(ch-'A'>=0 && ch-'A'<=25) {
                alphabets[ch-'A']++;
            } else {
                alphabets[25 + ch-'a']++;
            }
        }
        int sol = 0;
        boolean odd = false;
        for(int i=0; i<alphabets.length; i++) {
            if(alphabets[i]/2!=0) {
                sol = sol + ((alphabets[i]/2) * 2);
            }
            if (alphabets[i]%2!=0 && !odd) {
                odd = true;
            }
        }
        return odd ? sol + 1 : sol;
    }
}
