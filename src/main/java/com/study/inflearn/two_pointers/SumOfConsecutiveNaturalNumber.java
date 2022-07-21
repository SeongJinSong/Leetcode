package com.study.inflearn.two_pointers;

import java.util.Scanner;

public class SumOfConsecutiveNaturalNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SumOfConsecutiveNaturalNumber T = new SumOfConsecutiveNaturalNumber();
        System.out.println(T.solution3(n));
    }
    //공간복잡도 O(1)
    private int solution(int n) {
        int lt = 1, rt = 1;
        int sum = 0;
        int ans = 0;
        while (rt <= n) {
            if (sum >= n) {
                if (sum == n) ans++;
                sum -= lt++;
            } else if (sum < n) {
                sum += rt++;
            }
        }
        return ans;
    }

    private int solution2(int n) {
        int ans = 0, sum = 0, lt = 0, rt = 0;
        int m = n / 2 + 1;
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = i + 1;
        }
        while (rt <= m) {
            if (sum >= n) {
                if (sum == n) ans++;
                sum -= a[lt++];
            } else if (sum < n) {
                if (rt == m) break;
                sum += a[rt++];
            }
        }
        return ans;
    }

    //수학적인 방법
    private int solution3(int n) {
        int ans =0, cnt=1;
        n--;
        while (n > 0) {
            cnt++;
            n-=cnt;
            if(n%cnt==0)ans++;
        }
        return ans;
    }
}