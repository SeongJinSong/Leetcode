package com.study.inflearn.sorting_and_searching;

import java.util.HashSet;
import java.util.Scanner;

public class CheckDuplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        CheckDuplication T = new CheckDuplication();
        System.out.println(T.solution(a));
    }

    private String solution(int[] a) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : a) {
            if(hs.contains(i))return "D";
            else hs.add(i);
        }
        return "U";
    }
}
