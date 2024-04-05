package com.example.coding;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stOne;
    Stack<Integer> stTwo;
    public MyQueue() {
        stOne = new Stack<>();
        stTwo = new Stack<>();
    }

    public void push(int x) {
        while(!stOne.empty()) {
            stTwo.push(stOne.peek());
            stOne.pop();
        }
        stTwo.push(x);
        while (!stTwo.empty()) {
            stOne.push(stTwo.peek());
            stTwo.pop();
        }
    }

    public int pop() {
        return stOne.pop();
    }

    public int peek() {
        return stOne.peek();
    }

    public boolean empty() {
        return stOne.empty();
    }
}
