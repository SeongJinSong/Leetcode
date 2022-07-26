package com.study.inflearn.dfs;

import java.util.Scanner;

public class GetTheMaximumScore {
    static int n;
    static int m;
    static int[][]a;
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        GetTheMaximumScore T = new GetTheMaximumScore();
        T.dfs(0, 0, 0);
        System.out.println(max);
    }

    private void dfs(int depth, int sum, int time) {
        if(time>m) return;
        if(depth==n){
            max = Math.max(sum, GetTheMaximumScore.max);
            return;
        }
        dfs(depth + 1, sum + a[depth][0], time + a[depth][1]);
        dfs(depth + 1, sum, time);
    }
}
