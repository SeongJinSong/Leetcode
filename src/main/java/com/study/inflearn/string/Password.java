package com.study.inflearn.string;

import com.study.inflearn.P;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        s = s.replaceAll("#", "1").replaceAll("\\*", "0");
        char[] a = new char[n];
        for (int i = 0; i < n; i++) {
            a[i] = (char)Integer.parseInt(s.substring(i * 7, (i+1) * 7 ), 2);
        }
        System.out.println(String.valueOf(a));
    }
}
