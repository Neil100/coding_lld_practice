package com.example.coding;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        int words = 0, index;
        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-'a']++;
            words++;
        }

        for(int i=0; i<t.length(); i++) {
            index = t.charAt(i)-'a';

            if(arr[index]<=0) {
                return false;
            }
            arr[index]--;
            words--;
        }
        if(words==0)
            return true;

        return false;
    }
}
