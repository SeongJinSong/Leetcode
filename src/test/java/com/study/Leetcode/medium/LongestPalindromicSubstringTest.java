package com.study.Leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {
    @Test
    void longestPalindrome(){
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        assertTrue(obj.isPalindromic("bab") || obj.isPalindromic("bb"));
        assertTrue(obj.longestPalindrome("babad").equals("aba")||obj.longestPalindrome("babad").equals("bab"));
        assertEquals("bb", obj.longestPalindrome("cbbd"));
        assertEquals("a", obj.longestPalindrome("a"));
        assertEquals("bb", obj.longestPalindrome("bb"));
        assertEquals("ccc", obj.longestPalindrome("ccc"));
        assertEquals("bb", obj.longestPalindrome("abb"));
    }
    @Test
    void longestPalindrome3(){
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        assertTrue(obj.isPalindromic("bab") || obj.isPalindromic("bb"));
        assertTrue(obj.longestPalindrome3("babad").equals("aba")||obj.longestPalindrome3("babad").equals("bab"));
        assertEquals("bb", obj.longestPalindrome3("cbbd"));
        assertEquals("a", obj.longestPalindrome3("a"));
        assertEquals("bb", obj.longestPalindrome3("bb"));
        assertEquals("ccc", obj.longestPalindrome3("ccc"));
        assertEquals("bb", obj.longestPalindrome3("abb"));
        assertEquals("aaaa", obj.longestPalindrome3("aaaa"));
    }
    @Test
    void longestPalindrome4(){
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        assertTrue(obj.isPalindromic("bab") || obj.isPalindromic("bb"));
        assertTrue(obj.longestPalindrome4("babad").equals("aba")||obj.longestPalindrome4("babad").equals("bab"));
        assertEquals("bb", obj.longestPalindrome4("cbbd"));
        assertEquals("a", obj.longestPalindrome4("a"));
        assertEquals("bb", obj.longestPalindrome4("bb"));
        assertEquals("ccc", obj.longestPalindrome4("ccc"));
        assertEquals("bb", obj.longestPalindrome4("abb"));
        assertEquals("aaaa", obj.longestPalindrome4("aaaa"));
    }
}