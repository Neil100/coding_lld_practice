package com.example.coding;

import java.util.HashMap;
import java.util.Map;

public class RanSomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<magazine.length(); i++) {
            if(map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i))+1);
            } else {
                map.put(magazine.charAt(i), 1);
            }
        }

        for(int i=0; i<ransomNote.length(); i++) {
            Character find = ransomNote.charAt(i);

            if(map.containsKey(find)) {
                Integer count = map.get(find);
                if(count==0)
                    return false;

                count--;
                map.put(find, count);
            } else {
                return false;
            }
        }

        return true;
    }
}
