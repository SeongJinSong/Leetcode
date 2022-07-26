package com.study.inflearn.dfs;

import java.util.Scanner;

public class SubsetWithTheSameSum {
    /**
     6
     1 3 5 6 7 10
     */
    static int[] a;
    static int total;
    static int n;
    static int cnt;
    static boolean ans=false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        cnt=0;
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
            total+=a[i];
        }
        SubsetWithTheSameSum T = new SubsetWithTheSameSum();
        System.out.println("total = " + total);
        T.dfs(0, 0);
        System.out.println(ans ?"YES":"NO");
        System.out.println("--------");
        ans=false;
        cnt=0;
        T.dfs2(0, 0);
        System.out.println(ans ?"YES":"NO");
    }

    private void dfs(int depth, int sum) {
        if(depth>=n)return;
        cnt++;
        System.out.println("cnt:"+cnt+" depth:" + depth + " sum:" + sum);
        if(sum*2==total){
            ans=true;
            return;
        }
        dfs(depth+1, sum+a[depth]);
        dfs(depth+1, sum);
    }

    private void dfs2(int depth, int sum) {
        if(ans)return;
        if(depth==n){
            if(sum*2==total){
                ans=true;
            }
            return;
        }
        cnt++;
        System.out.println("2 cnt:"+cnt+" depth:" + depth + " sum:" + sum);
        dfs2(depth+1, sum+a[depth]);
        dfs2(depth+1, sum);
    }
}
