package com.example.coding;

import java.util.HashMap;

public class MinimumWindowSubString {

    public String minWindow(String s, String t) {

        if(s.length()==0 || t.length()==0) {
            return "";
        }

        HashMap<Character, Integer> characterFrequencyInT = new HashMap<>();

        for(int i=0; i<t.length(); i++) {
            characterFrequencyInT.computeIfPresent(t.charAt(i), (k,v) -> v+1);
            characterFrequencyInT.computeIfAbsent(t.charAt(i),k -> Integer.valueOf(1));

            /*
                int count = dictT.getOrDefault(t.charAt(i), 0);
                dictT.put(t.charAt(i), count + 1);
             */
        }

        int required = characterFrequencyInT.size();
        int l = 0, r = 0;
        int formed = 0;

        HashMap<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = { -1, 0, 0 };

        while(r<s.length()) {

            char current = s.charAt(r);
            int count = windowCounts.getOrDefault(current, 0);
            windowCounts.put(current, count+1);

            if(characterFrequencyInT.containsKey(current) && windowCounts.get(current) == characterFrequencyInT.get(current).intValue()) {
                formed++;
            }

            while(l<=r && formed==required) {

                char c = s.charAt(l);

                if(ans[0]==-1 || r-l+1 < ans[0]) {
                    ans[0] = r-l+1;
                            ans[1] = l;
                                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c)-1);

                if(characterFrequencyInT.containsKey(c) && windowCounts.get(c)<characterFrequencyInT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }

        return ans[0]==-1 ? "" : s.substring(ans[1], ans[2]+1);
    }
}
