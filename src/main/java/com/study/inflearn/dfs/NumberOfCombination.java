package com.study.inflearn.dfs;

import java.util.Scanner;

public class NumberOfCombination {
    static int n, r;
    static int[][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        memo = new int[n+1][n+1];
        NumberOfCombination T = new NumberOfCombination();
        System.out.println(T.dfs(n, r));
    }

    private int dfs(int n, int r) {
        if(memo[n][r]>0) return memo[n][r];
        if(n<r)return 0;
        else if(n==r)return 1;
        else if(r==1)return n;
        else if(n==1||r==0)return 1;
        return memo[n][r]=dfs(n - 1, r - 1) + dfs(n - 1, r);
    }
}
