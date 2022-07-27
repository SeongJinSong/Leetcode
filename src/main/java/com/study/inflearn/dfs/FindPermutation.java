package com.study.inflearn.dfs;

import java.util.Scanner;

public class FindPermutation {
    static int n, m;
    static int[] a;
    static int[] check;
    static int[] path;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n];
        check = new int[n];
        path = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        FindPermutation T = new FindPermutation();
        T.dfs(0);
    }

    private void dfs(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : path) sb.append(i).append(" ");
            System.out.println(sb.substring(0, sb.length() - 1));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(check[i]==1)continue;
            check[i]=1;
            path[depth]=a[i];
            dfs(depth + 1);
            check[i]=0;
        }
    }
}
