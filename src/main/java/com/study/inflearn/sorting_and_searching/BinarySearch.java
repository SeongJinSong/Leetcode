package com.study.inflearn.sorting_and_searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int lt=0, rt=n-1, ans=0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if(a[mid]>m)rt=mid-1;
            else if(a[mid]<m)lt=mid+1;
            else {
                ans = mid + 1;
                break;
            }
        }
        System.out.println(ans);
    }
}
