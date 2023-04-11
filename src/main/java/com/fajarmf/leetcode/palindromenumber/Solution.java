package com.fajarmf.leetcode.palindromenumber;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    // Explanation:
    // 1. If the number is negative, it is not a palindrome
    // 2. If the number is positive, we need to reverse the number and compare it with the original number
    // 3. If the reversed number is the same as the original number, it is a palindrome
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reversedNumber = 0;
        int originalNumber = x;

        while (x > 0) {
            int remainder = x % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            x = x / 10;
        }

        return reversedNumber == originalNumber;
    }
}
