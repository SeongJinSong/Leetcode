package com.study.inflearn.dfs;

import com.study.inflearn.P;

import java.lang.reflect.Array;
import java.util.*;

public class PathSearch {
    /**
     * 5 9
     * 1 2
     * 1 3
     * 1 4
     * 2 1
     * 2 3
     * 2 5
     * 3 4
     * 4 2
     * 4 5
     */
    static int n;
    //인접 행렬
    static int[][] a;
    //인점 리스트
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    static int[] check;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        a = new int[n + 1][n + 1];
        check = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            a[r][c] = 1;
            if (map.get(r) == null) {
                map.put(r, new ArrayList<>(List.of(c)));
            } else {
                map.get(r).add(c);
            }
        }
        PathSearch T = new PathSearch();
        check[1] = 1;
        T.dfs(1);
        System.out.println("ans = " + ans);
        System.out.println("-----");
        ans = 0;
        T.dfs2(1);
        System.out.println("ans = " + ans);
        System.out.println("-----");
        ans =0 ;
        T.dfs3(1);
        System.out.println("ans = " + ans);

    }

    private void dfs(int start) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (check[i] != 0 || a[start][i] == 0) {
                cnt++;
                continue;
            }
            check[i] = 1;
//            System.out.print("["+i+"]");
            dfs(i);
            check[i] = 0;
        }
        if (cnt == n && start == 5) {
            ans++;
//            System.out.println();
        }
    }

    private void dfs2(int v) {
        if (v == n) {
            ans++;
            return;
        }
        for (int j = 1; j <= n; j++) {
            if (check[j] == 0 && a[v][j] == 1) {
                check[j] = 1;
                dfs(j);
                check[j] = 0;
            }
        }
    }
    private void dfs3(int v) {
        if (v == n) {
            ans++;
            return;
        }
        for (int j : map.get(v)) {
            if(check[j]==1)continue;
            check[j] = 1;
            dfs(j);
            check[j] = 0;
        }
    }
}
