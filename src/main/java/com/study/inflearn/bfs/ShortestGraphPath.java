package com.study.inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestGraphPath {
    static int n;
    static int[][] a;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        a = new int[n+1][n+1];
        visited = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            a[r][c] = 1;
        }
        ShortestGraphPath T = new ShortestGraphPath();

        T.bfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i+ " : "+ visited[i]);
        }
        System.out.println("----------");
        visited = new int[n + 1];
        T.bfs2(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i+ " : "+ visited[i]);
        }
    }

    private void bfs(int v) {
        int level=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        while (!q.isEmpty()) {
            System.out.println("-- level:"+level);
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                System.out.println("cur: " + cur);
                for (int next = v+1; next <= n; next++) {
                    if (a[cur][next] == 1&&visited[next]==0) {
                        visited[next]=level+1;
                        q.add(next);
                    }
                }
            }
            level++;
        }
    }

    private void bfs2(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                for (int next = v+1; next <= n; next++) {
                    if (a[cur][next] == 1&&visited[next]==0) {
                        visited[next]=visited[cur]+1;
                        q.add(next);
                    }
                }
            }
        }
    }
}
