package com.study.inflearn.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CurriculumDesign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String essential = sc.next();
        String enroll = sc.next();
        Queue<Character> q = new LinkedList<>();
        for (char c : essential.toCharArray()) {
            q.add(c);
        }
        boolean correct = true;
        for (char c : enroll.toCharArray()) {
            if(q.isEmpty())break;
            if (q.contains(c)) {
                if (q.poll() != c) {
                    correct = false;
                    break;
                }
            }
        }
        System.out.println(correct?"YES":"NO");
    }
}
