package com.study.inflearn.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Wrestler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
        }
        Arrays.sort(a, (x,y)->y[0]-x[0]);
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (max<a[i][1]){
                max=a[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
