package com.study.inflearn.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class SetUpStable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        Arrays.sort(x);
        int lt = 1, rt= x[x.length-1];
        int ans = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if(c<=count(x, mid)){
                ans = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static int count(int[] x, int mid) {
        int cnt = 1;
        int sum = 0;
        for (int i = 1; i < x.length; i++) {
            sum+=x[i]-x[i-1];
            if (sum >= mid) {
                cnt++;
                sum=0;
            }
        }
        return cnt;
    }
}
