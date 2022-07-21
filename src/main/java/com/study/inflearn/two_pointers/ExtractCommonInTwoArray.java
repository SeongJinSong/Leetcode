package com.study.inflearn.two_pointers;

import com.study.inflearn.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ExtractCommonInTwoArray {
    //5
    //1 3 9 5 2
    //5
    //3 2 5 7 8
    public static void main(String[] args) {
        ExtractCommonInTwoArray T = new ExtractCommonInTwoArray();
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
        P.print(T.solution(n, m, a, b));
    }
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1=0, p2=0;
        while (p1 < n && p2 < m) {
            if(a[p1]<b[p2])p1++;
            else if(a[p1]>b[p2])p2++;
            else {
                ans.add(a[p1]);
                p1++; p2++;
            }
        }
        return ans;
    }
}
