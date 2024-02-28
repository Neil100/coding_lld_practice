package com.example.coding;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int m = temperatures.length;
        int[] sol = new int[m];

        Stack<Integer> st = new Stack<>();
        int cNum, tNum, tIndex;;
        for(int i=0; i<m; i++) {
            cNum = temperatures[i];

            while(st.size()>0) {
                tIndex = st.peek();
                tNum = temperatures[tIndex];
                if(cNum>tNum) {
                    sol[tIndex] = i-tIndex;
                    st.pop();
                } else {
                    break;
                }
            }
            st.push(i);
        }
        return sol;
    }
}
