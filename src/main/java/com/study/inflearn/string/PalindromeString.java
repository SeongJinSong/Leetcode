package com.study.inflearn.string;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toUpperCase();
        int lt = 0, rt = s.length() - 1;
        boolean ans = true;
        while (lt < rt) {
            if (s.charAt(lt) == s.charAt(rt)) {
                lt++;
                rt--;
            }else{
                ans = false;
                break;
            }
        }
        System.out.println(ans?"YES":"NO");
        System.out.println("---------");
        StringBuilder sb = new StringBuilder(s).reverse();
        System.out.println(s.equalsIgnoreCase(sb.reverse().toString())?"YES":"NO");
    }
}
