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
            int tmp = Integer.parseInt(s.substring(i * 7, (i+1) * 7 ));
            a[i] = (char)convertDecimal(tmp);
        }
        System.out.println(String.valueOf(a));
    }

    private static int convertDecimal(int n) {
        int ans = 0;
        int cnt = 0;
        while (n > 0) {
            ans += (n % 10) * Math.pow(2, cnt++);
            n/=10;
        }
        return ans;
    }
}
