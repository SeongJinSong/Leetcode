package com.study.inflearn;

import java.util.ArrayList;

public class P {
    public static <T> void print(ArrayList<T> arr){
        for (T i : arr) {
            System.out.print(i+" ");
        }
    }
    public static <T> void print(T[] arr) {
        for (T i : arr) {
            System.out.print(i+" ");
        }
    }
    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
