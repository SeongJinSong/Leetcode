package com.study.inflearn.sorting_and_searching;

import java.util.Scanner;

public class MusicVideo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int lt, rt = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            rt+=a[i];
        }
        lt = a[n - 1];
        int ans = 0;
        while (lt <= rt) {
            int mid = (lt+rt)/2;
            int res = checkDvd(a, mid);
            System.out.println("mid:"+mid+" res:"+res);
            if(res<m)rt=mid-1;
            else if(res>m)lt=mid+1;
            else{
                ans=mid;
                rt=mid-1;
                lt=mid+1;
            }
        }
        System.out.println(ans);
    }

    private static int checkDvd(int[] a, int mid) {
        int res = 1;
        int sum = 0;
        for (int i : a) {
            sum+=i;
            if (sum > mid) {
                sum=i;
                res++;
            }
        }
        return res;
    }
}
