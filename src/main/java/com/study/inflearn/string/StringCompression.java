package com.study.inflearn.string;

import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int cnt = 0;
        char prev = 0;
        StringBuilder sb = new StringBuilder();
        char[] ch = new char[s.length() + 1];
        for (int i = 0; i < ch.length; i++) {
            if(i==ch.length-1)ch[i]=0;
            else ch[i] = s.charAt(i);
        }
        for (char c : ch) {
            if(prev==c)cnt++;
            else{
                if(cnt>1)sb.append(cnt);
                if(c!=0)sb.append(c);
                prev=c;
                cnt=1;
            }
        }
        System.out.println(sb);
    }
}
