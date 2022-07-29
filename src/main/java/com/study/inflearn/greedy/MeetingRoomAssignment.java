package com.study.inflearn.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoomAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        Arrays.sort(a, (x, y)->{
            if(x[1]==y[1]) return x[0] - y[0];
            return x[1] - y[1];
        });
        int cnt=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i][0]>=max) {
                max=a[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
