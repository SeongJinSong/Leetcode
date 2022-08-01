package com.study.inflearn.dp;

import java.util.Scanner;

public class CrossTheStoneBridge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n + 2];
        d[0]=1;
        d[1]=1;
        for (int i = 2; i <= n + 1; i++) {
            d[i] = d[i - 2] + d[i - 1];
        }
        System.out.println(d[n+1]);
    }
}
