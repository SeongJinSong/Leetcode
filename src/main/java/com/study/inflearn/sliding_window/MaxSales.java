package com.study.inflearn.sliding_window;

import com.study.inflearn.P;

import java.util.Scanner;

public class MaxSales {
    //10 3
    //12 15 11 20 25 10 20 19 13 15
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        MaxSales T = new MaxSales();
        System.out.println(T.solution2(n, k, a));
    }

    private int solution(int n, int k, int[] a) {
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += a[i];
        }
        for (int i = 1; i < n-k; i++) {
            int temp = 0;
            for (int j = i; j < i+k; j++) {
                temp += a[j];
            }
            if (temp > ans) {
                ans = temp;
            }
        }
        return ans;
    }

    private int solution2(int n, int k, int[] a) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        int max = sum;
//        for (int i = 1; i < n-k; i++) {
//            sum = sum - a[i - 1] + a[i + k - 1];
//            if (sum > max) {
//                max = sum;
//            }
//        }
        for (int i = k; i < n; i++) {
            sum+= a[i] - a[i-k];
            max = Math.max(max, sum);
        }
        return max;
    }

}
