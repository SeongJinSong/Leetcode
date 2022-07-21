package com.study.inflearn.sliding_window;

import java.util.Scanner;

public class SequentialSumOfSubArray {
    //8 6
    //1 2 1 3 1 1 1 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        SequentialSumOfSubArray T = new SequentialSumOfSubArray();
        System.out.println(T.solution(n, m, a));
    }

    private int solution(int n, int m, int[] a) {
        int lt=0, rt=0;
        int ans =0 ;
        int sum = 0;
        while (rt < n) {
            if (sum < m) {
                sum += a[rt++];
            } else {
                if (sum == m) {
                    ans++;
                }
                sum -= a[lt++];
            }
        }
        return ans;
    }
}
