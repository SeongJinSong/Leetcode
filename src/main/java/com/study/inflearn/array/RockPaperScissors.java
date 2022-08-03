package com.study.inflearn.array;

import com.study.inflearn.P;

import java.util.ArrayList;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        ArrayList<Character> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(a[i]==b[i]) arr.add('D');
            else if(a[i]==3&&b[i]==1) arr.add('B');
            else if(a[i]==1&&b[i]==3) arr.add('A');
            else{
                if(a[i]<b[i]) arr.add('B');
                else arr.add('A');
            }
        }
        P.print(arr);
    }
}
