package com.study.inflearn.dp;

import com.study.inflearn.P;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FindMaximumScore {
    static class Problem{
        int score, time;
        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] d = new int[m+1];
        ArrayList<Problem> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new Problem(sc.nextInt(), sc.nextInt()));
        }
        a.sort(Comparator.comparingInt(x -> x.time));
        //인덱스가 0->n으로 가는 방법은 a의 사용횟수가 무한할때만 가능하다.
        //a의 각 항목을 한번만 사용할 수 있다면 역순으로 인덱스를를타야한다.
        for (int i = 0; i < n; i++) {
            for (int j = a.get(i).time; j <= m; j++) {
                d[j] = Math.max(d[j], d[j-a.get(i).time]+a.get(i).score);
            }
        }
        P.print(d);
        System.out.println();
        System.out.println(d[m]); //우연히 답만 맞은것!
        FindMaximumScore T = new FindMaximumScore();
        System.out.println("------------------");
        System.out.println(T.solution(a, n, m));
    }

    private int solution(ArrayList<Problem> a, int n, int m) {
        int[] d = new int[m+1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= a.get(i).time; j--) {
                d[j] = Math.max(d[j], d[j - a.get(i).time] + a.get(i).score);
            }
        }
        P.print(d);
        System.out.println();
        return d[m];
    }
}
