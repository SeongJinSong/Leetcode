package com.study.inflearn.string;

import java.util.Scanner;

public class ExtractOnlyNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.replaceAll("[a-zA-Z]", "");
        System.out.println(Integer.parseInt(s));
    }
}
