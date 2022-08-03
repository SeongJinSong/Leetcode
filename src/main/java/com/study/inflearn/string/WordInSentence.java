package com.study.inflearn.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class WordInSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordInSentence T = new WordInSentence();
        String s = sc.nextLine();
        System.out.println(T.stringTokenizer(s));
        System.out.println(T.split(s));
    }

    private String split(String s) {
//        String[] carr = s.split(" ");
        String[] carr = s.split("\\s+");
        String maxStr = "";
        for (String str : carr) {
            if (str.length() > maxStr.length()) {
                maxStr = str;
            }
        }
        return maxStr;
    }

    private String stringTokenizer(String s) {
        StringTokenizer stk = new StringTokenizer(s);
        int cnt = stk.countTokens();
        int maxLen = 0;
        String maxStr = "";
        for (int i = 0; i < cnt; i++) {
            String tmp = stk.nextToken();
            if (maxLen < tmp.length()) {
                maxLen = tmp.length();
                maxStr = tmp;
            }
        }
        return maxStr;
    }
}
