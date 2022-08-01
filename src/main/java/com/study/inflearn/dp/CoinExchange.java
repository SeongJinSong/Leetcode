package com.study.inflearn.dp;

import java.util.*;

public class CoinExchange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        CoinExchange T = new CoinExchange();
        System.out.println(T.solution(a, m));
        System.out.println("-------------------");
        System.out.println(T.solution2(Arrays.stream(a).mapToInt(Integer::intValue).toArray(), n, m));

    }

    private int solution(Integer[] a, int m) {
        Arrays.sort(a, Collections.reverseOrder());
        int ans = 0;
        int i=0;
        while (m > 0) {
            if (m / a[i] >= 1) {
                ans += (m / a[i]);
                System.out.println("ans:"+ans+" a["+i+"]:"+a[i]+" ans:"+ans);
                m %= m/a[i];
            }
            i++;
        }
        return ans;
    }

    private int solution2(int[] a, int n, int m) {
        int[] d = new int[m+1];
        for (int i = 0; i <= m; i++) {
            d[i]=i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = a[i]; j <= m; j++) {
                d[j] = Math.min(d[j], d[j - a[i]] + 1);
            }
        }
        return d[m];
    }
}
