package com.study.inflearn.dfs;

import java.util.Scanner;

public class PetGetOnTruck {
    static int[] a;
    static int max = 0;
    static int c;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        PetGetOnTruck T = new PetGetOnTruck();
        T.dfs(0, 0);
        System.out.println(max);
    }

    private void dfs(int depth, int sum) {
        if (sum > c) return;
        if (depth >= n) {
            max = Math.max(max, sum);
            return;
        }
//        System.out.println("depth:"+depth+" sum:"+sum);
        dfs(depth + 1, sum + a[depth]);
        dfs(depth + 1, sum);
    }
}
