package com.study.inflearn.dfs;

import java.util.Scanner;

public class FindCombination {
    static int n, m;
    static int[] path;
    static int[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        path = new int[m];
        check = new int[n+1];
        FindCombination T = new FindCombination();
        T.dfs(0, 1);
        System.out.println("------");
        T.dfs2(0, 1);
    }

    private void dfs(int depth, int start) {
        if(depth==m){
            StringBuilder sb = new StringBuilder();
            for(int i:path) sb.append(i).append(" ");
            System.out.println(sb.substring(0, sb.length()-1));
            return;
        }
        for (int i = start; i <= n; i++) {
            if(check[i]==1)continue;
            path[depth]=i;
            check[i]=1;
            dfs(depth + 1, i+1);
            check[i]=0;
        }
    }
    private void dfs2(int depth, int start) {
        if(depth==m){
            StringBuilder sb = new StringBuilder();
            for(int i:path) sb.append(i).append(" ");
            System.out.println(sb.substring(0, sb.length()-1));
            return;
        }
        //조합은 체크 배열이 필요가 없다!
        for (int i = start; i <= n; i++) {
            path[depth]=i;
            dfs(depth + 1, i+1);
        }
    }
}
