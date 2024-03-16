package com.example.coding;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import static java.lang.Integer.max;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int sol = 0;
        Stack<Integer> dq = new Stack<>();

        dq.push(-1);
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                dq.push(i);
            } else {
                if(!dq.isEmpty()) {
                    int val = dq.pop();
//                    sol = max(sol, i-val);
                    if(val>0) {
                        sol = max(sol, i-val);
                    } else {
                        dq.push(i);
                    }
                }
            }
        }

        return sol;
    }
}
