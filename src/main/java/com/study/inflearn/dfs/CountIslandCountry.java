package com.study.inflearn.dfs;

import java.util.Scanner;

public class CountIslandCountry {
    static int n;
    static int[][] map;
    static int ans;
    static int[] dr = {1, -1, 0, 0, -1, 1, -1, 1};
    static int[] dc = {0, 0, 1, -1, -1, -1, 1, 1};
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
                    map[i][j]=0; //이부분을 추가하는걸 깜박했다. 시작점도 재귀부분과 같은 유형으로 처리해야한다는걸 잊지말자.
                    T.dfs(i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private void dfs(int r, int c) {
        for (int i = 0; i < 8; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(nr<0||nr>=n||nc<0||nc>=n||map[nr][nc]!=1)continue;
            map[nr][nc]=0;
            dfs(nr, nc);
        }
    }
}
