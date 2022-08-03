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
        System.out.println("----------");
        char[] ca = s.toCharArray();
        int lt=0, rt=ca.length-1;
        while (lt < rt) {
            if (Character.isAlphabetic(ca[lt])&&Character.isAlphabetic(ca[rt])) {
                char tmp = ca[lt];
                ca[lt] = ca[rt];
                ca[rt] = tmp;
                lt++;
                rt--;
            }
            if (!Character.isAlphabetic(ca[lt])) {
                lt++;
            }
            if (!Character.isAlphabetic(ca[rt])) {
                rt--;
            }
        }
        System.out.println(String.valueOf(ca));
    }
}
