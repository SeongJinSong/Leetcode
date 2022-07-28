package com.study.inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeExploration {
    static class Node{
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int[][] map = new int[7][7];
    static int[][] map2 = new int[7][7];
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                map2[i][j]=map[i][j]=sc.nextInt();
            }
        }

        MazeExploration T = new MazeExploration();
        System.out.println(T.bfs(new Node(0,0)));
        System.out.println("--------");
        System.out.println(T.bfs2(new Node(0, 0)));
    }

    private int bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        int level = 0;
        map[0][0]=1;
        q.add(node);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                if(cur==null)continue;
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r+ dr[j];
                    int nc = cur.c + dc[j];
                    if(nr==6&&nc==6)return level+1;
                    if(nr<0||nr>6||nc<0||nc>6||map[nr][nc]==1)continue;
                    map[nr][nc]=1;
                    q.add(new Node(nr, nc));
                }
            }
            level++;
        }
        return -1;
    }
    private int bfs2(Node node) {
        Queue<Node> q = new LinkedList<>();
        map2[0][0]=1;
        q.add(node);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int j = 0; j < 4; j++) {
                int nr = cur.r+ dr[j];
                int nc = cur.c + dc[j];
                if(nr==6&&nc==6)return map2[cur.r][cur.c];
                if(nr<0||nr>6||nc<0||nc>6||map2[nr][nc]!=0)continue;
                map2[nr][nc]=map2[cur.r][cur.c]+1;
                q.add(new Node(nr, nc));
            }
        }
        return -1;
    }
}
