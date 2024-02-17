package com.example.coding;

import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            Character inStack = st.peek(), currentChar = s.charAt(i);
            if(currentChar==')') {
                if(inStack=='(') {
                    st.pop();
                    continue;
                }
                return false;
            }
            if(currentChar=='}') {
                if(inStack=='{') {
                    st.pop();
                    continue;
                }
                return false;
            }
            if(currentChar==']') {
                if(inStack=='[') {
                    st.pop();
                    continue;
                }
                return false;
            }

            st.push(currentChar);
        }

        return true;
    }
}
