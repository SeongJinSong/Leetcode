package com.study.inflearn.dfs;

import java.util.Scanner;

public class FindDuplicatePermutations {
    static int n;
    static int m;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new int[m];
        FindDuplicatePermutations T = new FindDuplicatePermutations();
        T.dfs(0);
    }

    private void dfs(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(visited[i]).append(" ");
            }
            System.out.println(sb.substring(0, sb.length()-1));
            return;
        }
        for (int i = 1; i <= n; i++) {
            visited[depth] = i;
            dfs(depth + 1);
        }
    }
}
