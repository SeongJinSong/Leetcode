package com.study.inflearn.stack;

import java.util.Scanner;
import java.util.Stack;

public class RemoveParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        RemoveParentheses T = new RemoveParentheses();
        System.out.println(T.solution(s));
    }

    private String solution(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c=='(') stk.push(c);
            else if(c != ')'){
                if(stk.isEmpty()) sb.append(c);
            }else stk.pop();
        }
        return sb.toString();
    }
}
