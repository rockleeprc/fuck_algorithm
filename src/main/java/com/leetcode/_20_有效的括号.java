package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _20_有效的括号 {
    /**
     * 效率低
     *
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {
        while (s.contains("{}")
                || s.contains("()")
                || s.contains("[]")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }

    /**
     * 栈
     *
     * @param s
     * @return
     */
    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }

    /**
     * 队列
     *
     * @param s
     * @return
     */
    public static boolean isValid3(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '{') {
                deque.push('}');
            } else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            } else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{()}";
        System.out.println(isValid3(s));
    }
}
