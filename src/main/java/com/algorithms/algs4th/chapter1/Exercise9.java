package com.algorithms.algs4th.chapter1;

/**
 * input :  1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * output:  ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )

 * Created by WANG on 2018/6/21.
 */
public class Exercise9 {


    private static String getInfixExpression(String input) {

        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();
        String[] strs = input.split(" ");
        for (int i = 0; i < strs.length; i++) {
            String ch = strs[i];
            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                operators.push(ch);
            } else if (ch.equals(")")) {
                String v1 = operands.pop();
                String v2 = operands.pop();
                String op = operators.pop();
                operands.push("( " + v2 + " " + op + " " + v1 + " )");
            } else {
                operands.push(ch);
            }
        }
        return operands.pop();
    }

    // Parameter example: "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"
    public static void main (String args[]) {
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        System.out.println(getInfixExpression(input));
    }

}
