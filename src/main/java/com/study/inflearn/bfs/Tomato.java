package com.study.inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {
    static class Node{
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int n, m;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int cnt = 0;
    static int notBlank =0;
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    q.add(new Node(i, j));
                    cnt ++;
                }
                if (map[i][j] != -1) {
                    notBlank++;
                }

            }
        }
        Tomato T = new Tomato();
        System.out.println(T.bfs());
    }

    private int bfs() {
        int level = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                if(cur==null)continue;
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];
                    if(nr<0||nr>=m||nc<0||nc>=n||map[nr][nc]!=0)continue;
                    map[nr][nc]=level;
                    q.add(new Node(nr, nc));
                    cnt++;
                    if(cnt==notBlank)return level;
                }
            }
            level++;
        }
        System.out.println();
        return -1;
    }
}
