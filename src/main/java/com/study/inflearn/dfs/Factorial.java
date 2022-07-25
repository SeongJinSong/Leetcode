package com.study.inflearn.dfs;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Factorial T = new Factorial();
        System.out.println(T.dfs(n));
    }

    private int dfs(int n) {
        if(n==1)return 1;
        return n* dfs(n-1);
    }
}
