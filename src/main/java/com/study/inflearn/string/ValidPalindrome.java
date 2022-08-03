package com.study.inflearn.string;

import java.util.Scanner;

import static java.lang.Character.*;

public class ValidPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();
        int lt = 0, rt = s.length() - 1;
        boolean ans = true;
        while (lt < rt) {
            if (isAlphabetic(s.charAt(lt)) && isAlphabetic(s.charAt(rt))) {
                if (s.charAt(lt) == s.charAt(rt)) {
                    lt++;
                    rt--;
                }else{
                    ans = false;
                    break;
                }
            }
            if(!isAlphabetic(s.charAt(lt)))lt++;
            if(!isAlphabetic(s.charAt(rt)))rt--;
        }
        System.out.println(ans?"YES":"NO");
    }
}
