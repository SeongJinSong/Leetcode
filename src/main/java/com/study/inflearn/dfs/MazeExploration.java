package com.study.inflearn.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class MazeExploration {
    static int[][] map = new int[7][7];
    static int[][] check = new int[7][7];
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans = 0;
    static ArrayList<String> path = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<7;i++)
            for(int j=0;j<7;j++)map[i][j]=sc.nextInt();
        MazeExploration T = new MazeExploration();
        check[0][0]=1;
        T.dfs(0, 0);
        System.out.println(ans);
        System.out.println("-------");
        ans=0;
        T.dfs2(0, 0);
        System.out.println(ans);
    }

    private void dfs(int r, int c) {
        if (r == 6 && c == 6) {
            ans++;
//            for(String s:path) System.out.print(s+" ");
//            System.out.println();
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr<0||nr>6||nc<0||nc>6||check[nr][nc]==1||map[nr][nc]==1)continue;
            check[nr][nc]=1;
//            path.add("[" + nr + "][" + nc + "]");
            dfs(nr,nc);
            check[nr][nc]=0;
//            path.remove(path.size() - 1);
        }
    }
    private void dfs2(int r, int c) {
        if (r == 6 && c == 6) {
            ans++;
//            for(String s:path) System.out.print(s+" ");
//            System.out.println();
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr<0||nr>6||nc<0||nc>6||map[nr][nc]==1)continue;
            map[nr][nc]=1;
//            path.add("[" + nr + "][" + nc + "]");
            dfs(nr,nc);
            map[nr][nc]=0;
//            path.remove(path.size() - 1);
        }
    }
}
