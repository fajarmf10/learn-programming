package com.fajarmf.leetcode.validparentheses;

public class SecondSolution {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));

        assert isValid("()");
        assert isValid("()[]{}");
        assert !isValid("(]");
        assert !isValid("([)]");
        assert isValid("{[]}");
    }

    // The complexity is O(n) because we only loop through the string once
    public static boolean isValid(String s) {
        // 1. If the length of the string is odd, it is not valid
        if (s.length() % 2 != 0) return false;

        // 2. Create a stack
        char[] stack = new char[s.length()];
        int stackPosition = -1;

        // 3. Loop through the string
        for (char c : s.toCharArray()) {
            // 4. If the current character is an opener, push it to the stack
            if (c == '(' || c == '{' || c == '[') {
                stack[++stackPosition] = c;
            } else if (c == ')' || c == '}' || c == ']') {
                // 3.1. If the stack is empty, return false
                if (stackPosition < 0) return false;

                // 3.2. If the current character is a closer, pop the last element from the stack
                char lastCharInStack = stack[stackPosition--];
                // 3.3. If the last element is not the opener of the current character, return false
                if (c == ')' && lastCharInStack != '(') return false;
                if (c == '}' && lastCharInStack != '{') return false;
                if (c == ']' && lastCharInStack != '[') return false;
            } else {
                // 3.4. If the current character is not an opener or a closer, return false
                return false;
            }
        }

        // 6. If the stack is not empty, return false
        return stackPosition == -1;
    }
}
