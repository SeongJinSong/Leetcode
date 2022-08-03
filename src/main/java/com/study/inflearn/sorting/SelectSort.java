package com.study.inflearn.sorting;

import com.study.inflearn.P;

import java.util.Scanner;

public class SelectSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        for (int i = 0; i < n; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if(a[idx]>a[j])idx=j;
            }
            int temp = a[idx];
            a[idx] = a[i];
            a[i] = temp;
        }
        P.print(a);
    }
}