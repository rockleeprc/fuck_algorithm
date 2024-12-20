package com.leetcode._20;

import java.util.*;

public class _20_有效的括号 {
    /**
     * 效率低
     *
     * @param s
     * @return
     */
    public static boolean isValid1(String s) {
        while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
            // 匹配的字符替换为空
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        // 只要s为空，都能匹配括号
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
            // 左字符：push
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (stack.isEmpty()) // )}]时，栈为空，不匹配
                return false;
            else {// 栈不为空时，右字符与pop比较
                Character left = stack.pop();
                if (left == '(' && c != ')') return false;
                if (left == '{' && c != '}') return false;
                if (left == '[' && c != ']') return false;
            }
        }
        // char循环完，栈不为空 不匹配  例如：()[
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
            } else {
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }

    /**
     * 栈 + hash
     *
     * @param s
     * @return
     */
    public static boolean isValid4(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> dict = new HashMap<>();
        dict.put('{', '}');
        dict.put('(', ')');
        dict.put('[', ']');

        for (char c : s.toCharArray()) {
            // 左字符：push
            if (dict.containsKey(c))
                stack.push(c);
            else if (stack.isEmpty()) // )}]时，栈为空，不匹配
                return false;
            else {// 栈不为空时，右字符与pop比较

                if (c != dict.get(stack.pop())) return false;
            }
        }
        // char循环完，栈不为空 不匹配  例如：()[
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{{(){)}";
//        System.out.println(isValid2(s));

        s = "()";
        System.out.println(isValid4(s));

        s = "(]";
        System.out.println(isValid4(s));

        s = "()[]{}";
        System.out.println(isValid4(s));
    }
}
