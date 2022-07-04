package com.study.Leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {
    @Test
    void longestPalindrome(){
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        assertTrue(obj.isPalindromic("bab") || obj.isPalindromic("bb"));
        assertTrue(obj.longestPalindrome2("babad").equals("aba")||obj.longestPalindrome2("babad").equals("bab"));
        assertEquals("bb", obj.longestPalindrome2("cbbd"));
        assertEquals("a", obj.longestPalindrome2("a"));
        assertEquals("bb", obj.longestPalindrome2("bb"));
        assertEquals("ccc", obj.longestPalindrome2("ccc"));
    }
}