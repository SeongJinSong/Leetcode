package com.study.inflearn.array;

import com.study.inflearn.P;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintLargeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(a[0]);
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) arr.add(a[i]);
        }
        P.print(arr);
    }
}
