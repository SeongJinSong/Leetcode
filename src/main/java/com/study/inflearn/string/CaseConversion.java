package com.study.inflearn.string;

import java.util.Scanner;

public class CaseConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] carr = s.toCharArray();
        for (int i = 0; i < carr.length; i++) {
            if (carr[i] >= 65 && carr[i] <= 90) {
                carr[i]+=32;
            }else carr[i]-=32;
        }
        System.out.println(String.valueOf(carr));
        System.out.println("----------------");
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
            else sb.append(Character.toLowerCase(c));
        }
        System.out.println(sb);
    }
}
