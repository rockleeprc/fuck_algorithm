package com.leetcode._232;

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
        // 直接对inStack push
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.isEmpty()) {
            inStackToOutStaTock();
        }
        return outStack.pop();
    }

    private void inStackToOutStaTock() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            inStackToOutStaTock();
        }
        // 看一下队头元素，但不删除
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        // in、out栈都为空，队列才为空
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
