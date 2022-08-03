package com.study.inflearn.string;

import java.util.Scanner;
import java.util.Stack;

public class ReverseSpecificCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] carr = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < carr.length; i++) {
            if (Character.isLowerCase(carr[i]) || Character.isUpperCase(carr[i])) {
                stk.push(carr[i]);
                carr[i]='a';
            }
        }
        for (int i = 0; i < carr.length; i++) {
            if (carr[i] == 'a') {
                carr[i] = stk.pop();
            }
        }
        System.out.println(String.valueOf(carr));
    }
}
