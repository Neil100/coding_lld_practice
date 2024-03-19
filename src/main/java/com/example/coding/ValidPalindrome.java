package com.example.coding;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        String lowerCase = s.toLowerCase();
//        String operatedString="";
//        for(int i=0; i<lowerCase.length(); i++) {
//            if((lowerCase.charAt(i)>='a' && lowerCase.charAt(i)<='z')||(lowerCase.charAt(i)>='0' && lowerCase.charAt(i)<='9')) {
//                operatedString = operatedString + lowerCase.charAt(i);
//            }
//        }

        int l = 0, r = lowerCase.length()-1;
        char c1, c2;
        while(l<=r) {
            c1 = lowerCase.charAt(l);
            c2 = lowerCase.charAt(r);
            if(!((c1>='a' && c1<='z')||(c1>='0' && c1<='9'))) {
                l++;
                continue;
            }

            if(!((c2>='a' && c2<='z')||(c2>='0' && c2<='9'))) {
                r--;
                continue;
            }
            if(!(c1==c2)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
