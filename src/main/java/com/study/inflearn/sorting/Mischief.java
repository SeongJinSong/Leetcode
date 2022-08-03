package com.study.inflearn.sorting;

import com.study.inflearn.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mischief {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = a.clone();
        Arrays.sort(b);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=b[i])res.add(i+1);
        }
        P.print(res);
    }
}
