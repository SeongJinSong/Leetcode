package com.study.inflearn.sorting;

import com.study.inflearn.P;

import java.util.Scanner;

public class InsertSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 1; i < n; i++) {
            int tmp=a[i], j;
            for (j = i - 1; j >= 0; j--) {
                if(a[j]>tmp)a[j+1]=a[j];
                else break;
            }
            a[j+1]=tmp;
        }
        P.print(a);
    }
}
