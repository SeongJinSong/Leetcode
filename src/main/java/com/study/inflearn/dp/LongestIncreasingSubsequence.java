package com.study.inflearn.dp;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            d[i] = 1;
        }
        d[0]=1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (a[i] > a[j]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
            max = Math.max(max, d[i]);
        }
        System.out.println(max);
    }
}
