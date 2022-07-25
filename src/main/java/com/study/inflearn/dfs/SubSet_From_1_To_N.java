package com.study.inflearn.dfs;

import java.util.Scanner;

public class SubSet_From_1_To_N {
    static int n;
    static int[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SubSet_From_1_To_N T = new SubSet_From_1_To_N();
        n = sc.nextInt();
        check = new int[n + 1];
        T.dfs(1);
    }

    private void dfs(int depth) {
        if (depth > n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (check[i] == 1) {
                    sb.append(i).append(" ");
                }
            }
            if(sb.length()>0) System.out.println(sb.substring(0, sb.length()-1));
            return;
        }
        check[depth] = 1;
        dfs(depth + 1);
        check[depth] = 0;
        dfs(depth + 1);
    }
}
