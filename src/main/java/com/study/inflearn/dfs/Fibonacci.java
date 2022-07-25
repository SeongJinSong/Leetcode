package com.study.inflearn.dfs;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Fibonacci T = new Fibonacci();
        System.out.println("----first----");
        T.dfs(0, 1, 0, n);
        System.out.println();
        System.out.println("----second----");
        System.out.println(T.dfs(10));
        System.out.println("----third----");
        System.out.println(T.dfs2(10));
    }

    private void dfs(int depth, int prev, int cur, int n) {
        if(depth==n)return;
        System.out.print(prev+cur+" ");
        dfs(depth + 1, cur, prev + cur, n);
    }
    private int dfs(int n) {
        if(n==1) return 1;
        else if(n==2) return 1;
        return dfs(n - 1) + dfs(n - 2);
    }
    int[] a;
    private int dfs2(int n) {
        int[] a = new int[n+1];
        a[1]=1;
        a[2]=1;
        for (int i = 3; i <= n; i++) {
            a[i] = a[i - 2] + a[i - 1];
        }
        return a[n];
    }
}
