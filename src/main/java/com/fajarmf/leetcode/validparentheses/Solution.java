package com.fajarmf.leetcode.validparentheses;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    // Explanation:
    // 1. If the length of the string is odd, it is not valid
    // 2. Create a stack
    // 3. Loop through the string
    // 4. If the current character is an opener, push it to the stack
    // 5. If the current character is a closer, pop the last element from the stack
    // 6. If the last element is not the opener of the current character, return false
    // 7. If the stack is not empty, return false
    // 8. If the loop is finished, return true
    // The complexity is O(n) because we only loop through the string once
    public static boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;

        char[] openerList = {'(', '[', '{'};
        char[] closer = {')', ']', '}'};

        char[] stack = new char[s.length()];
        int top = -1;

        for(int i = 0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            boolean isOpener = false;
            for (char openerChar : openerList) {
                if (currentChar == openerChar) {
                    isOpener = true;
                    stack[++top] = currentChar;
                    break;
                }
            }

            if(!isOpener) {
                if(top < 0) return false;
                char last = stack[top--];
                for(int j = 0; j<openerList.length; j++) {
                    if(last == openerList[j]) {
                        if(currentChar != closer[j]) return false;
                        break;
                    }
                }
            }
        }

        return top == -1;
    }
}
