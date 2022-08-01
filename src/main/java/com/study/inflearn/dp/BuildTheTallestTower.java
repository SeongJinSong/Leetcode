package com.study.inflearn.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BuildTheTallestTower {
    static class Brick{
        int bottom, height, weight;
        public Brick(int bottom, int height, int weight) {
            this.bottom = bottom;
            this.height = height;
            this.weight = weight;
        }
    }
    static int[] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n];
        ArrayList<Brick> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        a.sort((x, y) -> y.bottom - x.bottom);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int minWeight = a.get(i).weight;
            int sumOfHeight = a.get(i).height;
            for (int j = i + 1; j < n; j++) {
                if (a.get(j).weight > minWeight) continue;
                minWeight = a.get(j).weight;
                sumOfHeight += a.get(j).height;
            }
            ans = Math.max(ans, sumOfHeight);
        }
        System.out.println(ans);
        System.out.println("-----------");
        BuildTheTallestTower T = new BuildTheTallestTower();
        System.out.println(T.solution(a));
    }

    private int solution(ArrayList<Brick> a) {
        int ans = 0;
        a.sort((x, y) -> y.bottom - x.bottom);
        for (int i=0;i<a.size();i++) {
            d[i] = a.get(i).height;
        }
        for (int i = 0; i < a.size(); i++) {
            int max_h = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (a.get(j).weight > a.get(i).weight && d[j] > max_h) {
                    max_h = d[j];
                }
            }
            d[i]=max_h+a.get(i).height;
            ans = Math.max(ans, d[i]);
        }
        return ans;
    }
}
