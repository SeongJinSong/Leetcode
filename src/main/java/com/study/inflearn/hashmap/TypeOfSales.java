package com.study.inflearn.hashmap;

import com.study.inflearn.P;

import java.util.HashMap;
import java.util.Scanner;

public class TypeOfSales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);
            ans[0]=hm.size();
        }
        for (int i = k; i < n; i++) {
            if(hm.get(a[i-k])==1) hm.remove(a[i - k]);
            else hm.put(a[i - k], hm.get(a[i - k]) - 1);
            hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);
            ans[i-k+1] = hm.size();
        }
        P.print(ans);
    }
}
