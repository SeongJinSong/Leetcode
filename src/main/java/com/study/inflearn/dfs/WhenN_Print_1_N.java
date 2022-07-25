package com.study.inflearn.dfs;

import com.study.inflearn.P;

import java.util.Scanner;

public class WhenN_Print_1_N {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        WhenN_Print_1_N T = new WhenN_Print_1_N();
        P.print(T.solution(n));
    }

    private int[] solution(int n) {
        int[] a = new int[n];
//        dfs(1, a);
        dfs2(n, a);
        return a;
    }

    private void dfs(int depth, int[] a) {
        if (depth > a.length) {
            return;
        }
        a[depth-1]=depth;
        dfs(depth+1, a);
    }
    private void dfs2(int n, int[] a) {
        if (n==0) return;
        dfs2(n-1, a);
        System.out.print(n+" ");
    }
}
