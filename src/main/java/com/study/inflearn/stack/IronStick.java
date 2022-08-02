package com.study.inflearn.stack;

import java.util.*;

public class IronStick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String converted = s.replaceAll("\\(\\)", "-");
        ArrayList<Integer> a = new ArrayList<>();
        int ans = 0;
        for (char c : converted.toCharArray()) {
            if(c=='(') {
                a.add(0);
            } else if (c == '-') {
                for (int i = 0; i < a.size(); i++) {
                    a.set(i, a.get(i) + 1);
                }
            } else {
                ans += a.remove(a.size() - 1)+1;
            }
        }
        System.out.println(ans);
        System.out.println("---------------");
        IronStick T = new IronStick();
        System.out.println(T.solution(s));
    }

    private int solution(String s) {
        Stack<Character> stk = new Stack<>();
        int ans = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') stk.push('(');
            else {
                stk.pop();
                if(s.charAt(i-1)=='(')ans+=stk.size();
                else ans++;
            }
        }
        return ans;
    }
}
