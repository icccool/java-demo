package com.algorithms.algs4th.chapter0;

/**
 * 双栈实现表达式计算
 *
 * Created by WANG on 2018/6/21.
 */
public class Evaluation {

    public static void main(String[] args) {
        String str = "((1+2)*2)";
        Stack<Character> ops = new Stack<Character>();
        Stack<Double> vals = new Stack<Double>();
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            switch (s) {
                case '(':
                    continue;
                case '+':
                    ops.push(s);
                    break;
                case '-':
                    ops.push(s);
                    break;
                case '*':
                    ops.push(s);
                    break;
                case '/':
                    ops.push(s);
                    break;
                case ')':
                    double v1 = vals.pop();
                    char op = ops.pop();
                    if (op == '+') {
                        vals.push(vals.pop() + v1);
                    } else if (op == '-') {
                        vals.push(vals.pop() - v1);
                    } else if (op == '*') {
                        vals.push(vals.pop() * v1);
                    } else if (op == '/') {
                        vals.push(vals.pop() / v1);
                    }
                    break;
                default:
                    vals.push(Double.parseDouble(s + ""));
                    break;
            }
        }
        System.out.println("result=" + vals.pop());

    }
}
