package com.algorithms.algs4th.chapter1;

/**
 * [()]{} 输出 true
 * {[()}  输出 false
 *
 * Created by WANG on 2018/6/21.
 */
public class Parentheses {
    public static void main(String[] args) {
        String parent = "{[()}";
        Stack<Character> stack = new Stack<Character>();
        boolean bool = true;
        for (int i = 0; i < parent.length() && bool; i++) {
            char c = parent.charAt(i);
            switch (c) {
                case '[':
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    Character c1 = stack.pop();
                    if (c1 == null || c1 != '(') {
                        bool = false;
                    }
                    break;
                case ']':
                    Character c2 = stack.pop();
                    if (c2 == null || c2 != '[') {
                        bool = false;
                    }
                    break;
                case '}':
                    Character c3 = stack.pop();
                    if (c3 == null || c3 != '{') {
                        bool = false;
                    }
                    break;
                default:
                    bool = false;
                    break;
            }
        }
        System.out.println("bool = " + bool);

    }
}
