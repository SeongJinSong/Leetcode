package com.study.inflearn.stack;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PostfixOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Integer> stk = new Stack<>();
        HashSet<Character> op = new HashSet<>(List.of('+', '-', '*','/'));
        for (char c : s.toCharArray()) {
            if (op.contains(c)) {
                stk.push(calc(stk.pop(), stk.pop(), c));
            }else{
                stk.push(c-'0');
            }
        }
        System.out.println(stk.pop());
    }

    private static int calc(int a, int b, char op) {
        return switch (op) {
            case '+' -> b + a;
            case '-' -> b - a;
            case '*' -> b * a;
            case '/' -> b / a;
            default -> 0;
        };
    }
}
