package com.study.inflearn.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class CoinExchange {
    static int n, m;
    static int[] a;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //정렬해서 역순으로해야 시간복잡도가 줄어든다.
        Arrays.sort(a);
        m = sc.nextInt();
        CoinExchange T = new CoinExchange();
        T.dfs(0, 0);
        System.out.println(min);
    }

    private void dfs(int depth, int sum) {
        if(sum>m) return;
        if(min<=depth)return;
        if(sum==m) {
            System.out.println("depth:"+depth);
            min = Math.min(min, depth);
            return;
        }
        for (int i = n-1; i >=0; i--) {
            dfs(depth + 1, sum + a[i]);
        }
    }
}
