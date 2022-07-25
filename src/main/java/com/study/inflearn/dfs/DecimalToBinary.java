package com.study.inflearn.dfs;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DecimalToBinary T = new DecimalToBinary();
//        System.out.println(T.solution(n));
        T.solution2(n);
    }
    private String solution(int n) {
        return dfs(n);
    }
    private void solution2(int n) {
        dfs2(n);
    }

    public String dfs(int n) {
        if(n==0)return "";
        return n % 2 + dfs(n / 2);
    }

    public void dfs2(int n) {
        if(n==0)return;
//        System.out.print(n%2);    //1101
        dfs2(n/2);
        System.out.print(n%2);  // 1011
    }
}
