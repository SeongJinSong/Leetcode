package com.study.inflearn.two_pointers_sliding_window;

import java.util.ArrayList;
import java.util.Scanner;

public class TwoPointerAlgorithm {
    public static void main(String[] args) {
        TwoPointerAlgorithm T = new TwoPointerAlgorithm();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        T.print(T.solution(n, m, a, b));
    }

    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        int p1=0,p2=0;
        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) {
                ans.add(a[p1++]);
            } else if (a[p1] > b[p2]) {
                ans.add(b[p2++]);
            }else{
                ans.add(a[p1++]);
                ans.add(b[p2++]);
            }
        }
//        if (p1 >= n) {
//            for (int idx = p2; idx < m; idx++) {
//                ans.add(b[idx]);
//            }
//        } else {
//            for (int idx = p1; idx < n; idx++) {
//                ans.add(a[idx]);
//            }
//        }
        while(p1<n) ans.add(a[p1++]);
        while(p2<m) ans.add(b[p2++]);

        return ans;
    }
    public void print(ArrayList<Integer> arr){
        for (Integer i : arr) {
            System.out.print(i+" ");
        }
    }
}
