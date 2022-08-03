package com.study.inflearn.string;

import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int cnt = 0;
        char prev = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(prev==c)cnt++;
            else{
                if(cnt>1)sb.append(cnt);
                sb.append(c);
                prev=c;
                cnt=1;
            }
        }
        System.out.println(sb);
    }
}
