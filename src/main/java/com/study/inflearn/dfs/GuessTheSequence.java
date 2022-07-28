package com.study.inflearn.dfs;

import com.study.inflearn.P;

import java.util.Scanner;

public class GuessTheSequence {
    static int n, f;
    static int[] path;
    static int[] check; // 중복순열은 체크배열이 있어야한다.
    static int[] multiply;
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        path = new int[n];
        check = new int[11];
        multiply = new int[n];
        for (int i = 0; i < n; i++) {
            multiply[i] = comb(n - 1, i);
        }
        GuessTheSequence T = new GuessTheSequence();
        T.dfs(0, 0);
    }
    private void dfs(int depth, int sum) {
        if(flag)return;
        if (depth == n) {
            if (sum == f) {
                flag = true;
                P.print(path);
            }
            return;
        }
        for (int i = 1; i <= 10; i++) {
            if(check[i]==1)continue;
            path[depth]=i;
            check[i]=1;
            dfs(depth+1, sum+i*multiply[depth]);
            check[i]=0;
        }
    }
    private static int comb(int n, int r) {
        int p = 1;
        for (int i = 0; i < r; i++) {
            p *= (n - i);
        }
        int s = 1;
        for (int i = 1; i <= r; i++) {
            s *= i;
        }
        return p/s;
    }
}
