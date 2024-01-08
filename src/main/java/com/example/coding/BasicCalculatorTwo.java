package com.example.coding;

import java.util.ArrayList;

public class BasicCalculatorTwo {
    public int calculate(String s) {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Character> operation = new ArrayList<>();
        operation.add(Character.valueOf('f'));
        String number="";
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)==' ' || s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/') {
                if(number.length()!=0) {
                    numbers.add(Integer.parseInt(number));
                    number="";
                }
                if(s.charAt(i)!=' ') {
                    operation.add(s.charAt(i));
                }
            } else {
                number = number + s.charAt(i);
            }
        }

        if(number.length()!=0)
            numbers.add(Integer.parseInt(number));

        for(int i=0; i<operation.size()-1; i++) {
            if(operation.get(i+1)=='/') {
                numbers.set(i, numbers.get(i)/numbers.get(i+1));
                operation.remove(i+1);
                numbers.remove(i+1);
                i--;
            } else if(operation.get(i+1)=='*') {
                numbers.set(i, numbers.get(i)*numbers.get(i+1));
                operation.remove(i+1);
                numbers.remove(i+1);
                i--;
            }
        }

        for(int i=0; i<operation.size()-1; i++) {
            if(operation.get(i+1)=='+') {
                numbers.set(i, numbers.get(i)+numbers.get(i+1));
                operation.remove(i+1);
                numbers.remove(i+1);
                i--;
            } else if(operation.get(i+1)=='-') {
                numbers.set(i, numbers.get(i)-numbers.get(i+1));
                operation.remove(i+1);
                numbers.remove(i+1);
                i--;
            }
        }
        return numbers.get(0);
    }
}
