package com.study.inflearn.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EmergencyRoom {
    static class Patient {
        int idx, severity;

        public Patient(int idx, int severity) {
            this.idx = idx;
            this.severity = severity;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Patient> q = new LinkedList<>();
        int pollCnt = 0;
        for (int i = 0; i < n; i++) {
            int severity = sc.nextInt();
            q.add(new Patient(i, severity));
        }
        while (!q.isEmpty()) {
            Patient cur = q.poll();
            boolean max = true;
            for (Patient p : q) {
                if (p.severity > cur.severity) {
                    max = false;
                    break;
                }
            }
            if(!max) q.add(cur);
            else {
                pollCnt++;
                if(cur.idx==m)break;
            }
        }
        System.out.println(pollCnt);
    }
}
