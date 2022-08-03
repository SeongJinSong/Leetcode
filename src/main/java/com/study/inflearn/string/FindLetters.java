package com.study.inflearn.string;

import java.util.Locale;
import java.util.Scanner;

public class FindLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toUpperCase();
        char c = sc.next().toUpperCase().charAt(0);
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if(ch==c)ans++;
        }
        System.out.println(ans);
    }
}
