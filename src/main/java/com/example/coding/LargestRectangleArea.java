package com.example.coding;

import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int[] rightClosestSmall = new int[heights.length];
        Stack<Integer> st = new Stack<>();

        int length = heights.length;
        st.push(length);
        for(int i=length-1; i>=0; i--) {
            int num = heights[i];
            int index = st.peek();

            if(index==length) {
                rightClosestSmall[i] = length;
                st.push(i);
            } else {
                while(true) {
                    if(index==length) {
                        rightClosestSmall[i] = length;
                        st.push(i);
                        break;
                    }
                    if(heights[i]>heights[index]) {
                        rightClosestSmall[i] = index;
                        st.push(i);
                        break;
                    } else {
                        st.pop();
                        index = st.peek();
                    }
                }
            }
        }


        while(!st.empty())
            st.pop();

        st.push(-1);
        int sol = Integer.MIN_VALUE;
        for(int i=0; i<length; i++) {
            int num = heights[i];
            int index = st.peek();
            int solIndex;
            if(index==-1) {
                solIndex = -1;
                st.push(i);
            } else {
                while(true) {
                    if(index==-1) {
                        solIndex = -1;
                        st.push(i);
                        break;
                    }
                    if(heights[i]>heights[index]) {
                        solIndex = index;
                        st.push(i);
                        break;
                    } else {
                        st.pop();
                        index = st.peek();
                    }
                }
            }
            sol = Integer.max(sol, heights[i]*(rightClosestSmall[i]-solIndex-1));
        }

        return sol;
    }
}
