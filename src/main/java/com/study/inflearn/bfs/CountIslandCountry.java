package com.study.inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountIslandCountry {
    static int n;
    static int[][] map;
    static int ans;
    static int[] dr = {1, -1, 0, 0, -1, 1, -1, 1};
    static int[] dc = {0, 0, 1, -1, -1, -1, 1, 1};
    static class Node{
        int r, c;
        public Node(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j]=sc.nextInt();
            }
        }
        CountIslandCountry T = new CountIslandCountry();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    T.bfs(i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
    private void bfs(int r, int c) {
        Queue<Node> q =new LinkedList<>();
        map[r][c]=0;
        q.add(new Node(r, c));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || map[nr][nc] != 1) continue;
                map[nr][nc] = 0;
                q.add(new Node(nr, nc));
            }
        }
    }
}
