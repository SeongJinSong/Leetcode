package com.study.inflearn.stack;

import java.util.Scanner;
import java.util.Stack;

public class CorrectParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        CorrectParenthesis T = new CorrectParenthesis();
        System.out.println(T.solution(s));
    }

    private String solution(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='(') stk.push(c);
            else {
                if (stk.isEmpty()) {
                    return "NO";
                } else stk.pop();
            }
        }
        return stk.isEmpty()?"YES":"NO";
    }
}
