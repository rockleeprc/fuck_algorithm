package com.leetcode;

import java.util.Stack;

public class _232_用栈实现队列 {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public _232_用栈实现队列() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.isEmpty()) {
            inStack2OutStack();
        }
        return outStack.pop();
    }

    private void inStack2OutStack() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            inStack2OutStack();
        }
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        _232_用栈实现队列 queue = new _232_用栈实现队列();
        queue.push(1);
        queue.push(3);
        queue.push(99);
        System.out.println(queue.pop()==1);
        System.out.println(queue.peek()==3);
        System.out.println(queue.empty()==false);
    }
}
