package com.example.coding;

public class DecodeWays {
    public int numDecodings(String s) {
        // use recurssion.
    	int[] arr = new int[s.length()];
    	for(int i=0; i<s.length(); i++) {
    		arr[i] = Integer.MIN_VALUE;
    	}
        return numberOfDecodings(s, 0, arr);
    }

    int numberOfDecodings(String s, int index, int[] arr) {
        
        int sol = 0;
        if(index>=s.length()) {
        	return 1;
        }
        if(arr[index]!=Integer.MIN_VALUE) {
        	return arr[index];
        }
        int numberOne = Integer.parseInt(s.substring(index, index+1));
        if(numberOne>0 && numberOne<27) {
        	sol += numberOfDecodings(s, index+1, arr); 
        }
        
        if(index+1 < s.length()) {
        	int numberTwo = Integer.parseInt(s.substring(index, index+2));
            
            if(numberTwo>9 && numberTwo<27) {
            	sol += numberOfDecodings(s, index+2, arr); 
            }
        }
        arr[index] = sol;
        
        return sol;
    }
}
