package com.study.inflearn.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PizzaDeliveryDistance {
    static int n, m;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static ArrayList<Node> home = new ArrayList<>();
    static ArrayList<Node> store = new ArrayList<>();
    static int[] comb;
    static int min = Integer.MAX_VALUE;
    static class Node{
        int r,c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        comb = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j]=sc.nextInt();
                if(map[i][j]==1) home.add(new Node(i, j));
                if(map[i][j]==2) store.add(new Node(i, j));
            }
        }
        PizzaDeliveryDistance T = new PizzaDeliveryDistance();
        T.dfs(0, 0);
        System.out.println(min);
        System.out.println("------------");
        min = Integer.MAX_VALUE;
        T.dfs2(0, 0);
        System.out.println(min);
    }
    //피자집이 생존하는 경우의 수 처리
    private void dfs(int depth, int selected) {
        if(depth==store.size()){
            if (selected == m) {
                int sum = 0 ;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if(map[i][j]==1) sum += bfs(i, j);
                    }
                }
                min = Math.min(min, sum);
            }
            return;
        }
        Node cur = store.get(depth);
        map[cur.r][cur.c]=0;
        dfs(depth+1, selected);
        map[cur.r][cur.c]=2;
        dfs(depth+1, selected+1);
    }
    //집에서 가장 가까운 피자집 찾기
    private int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        int[][] check = new int[n][n];
        for(int i=0;i<n;i++)
            System.arraycopy(map[i], 0, check[i], 0, n);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();
                if(cur==null)continue;
                for (int j = 0; j < 4; j++) {
                    int nr = cur.r+dr[j];
                    int nc = cur.c+dc[j];
                    if(nr<0||nr>=n||nc<0||nc>=n||map[nr][nc]==1||check[nr][nc]==1)continue;
                    if(map[nr][nc]==2)return level+1;
                    check[nr][nc]=1;
                    q.add(new Node(nr, nc));
                }
            }
            level++;
        }
        System.out.println("########");
        return 0;
    }
    //중간에 장애물이 있는 경우가 아니므로 bfs 없이 처리하는게 훨씬 쉽다.
    //나는 일반집도, 장애물이 될 수 있다고 생각해서 bfs가 필요하다고 생각했는데,, 솔루션은 그케이스는 고려 안한듯 싶다.
    private void dfs2(int depth, int start) {
        if(depth==m){
            int sum=0;
            for (Node h : home) {
                int dis = Integer.MAX_VALUE;
                for (int i : comb) {
                    dis = Math.min(dis, Math.abs(h.r - store.get(i).r) + Math.abs(h.c - store.get(i).c));
                }
                sum+=dis;
            }
            min = Math.min(min, sum);
            return;
        }
        for (int i = start; i < store.size(); i++) {
            comb[depth]=i;
            dfs2(depth+1, start+1);
        }
    }
}
