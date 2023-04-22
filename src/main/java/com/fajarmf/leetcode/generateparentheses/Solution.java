package com.fajarmf.leetcode.generateparentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    // Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    // Example:
    //      - Input: n = 3
    //        Output: ["((()))","(()())","(())()","()(())","()()()"]
    //      - Input: n = 1
    //        Output: ["()"]
    public static List<String> generateParenthesis(int n) {
        // it means there will be 2xn array of parentheses
        // we need to find the combination of parentheses that is valid
        // it should be started with "(" and ended with ")"
        List<String> output = new ArrayList<>();
        backtrack(output, "", 0, 0, n);
        return output;
    }

    // Backtracking function
    // Backtracking is an algorithm for finding all solutions by exploring all potential candidates.
    // If the solution candidate turns to be not a solution (or at least not the last one), backtracking algorithm discards it by making some changes on the previous step, i.e. backtracks and then try again.
    // The word backtrack comes from the Latin verb baculare, meaning "to use a stick".
    // The idea is to start from the initial state and explore all possible candidates for the next step.
    // If the candidate turns to be not a solution, backtracking algorithm discards it by making some changes on the previous step.
    // If the candidate turns to be a solution, it is added to the solution set.
    // The candidate selection process is done in a recursive manner.
    // The recursion ends when there are no more candidates possible.
    public static void backtrack(List<String> output, String current, int open, int close, int max) {
        // if the length of the current string is equal to 2 * max, it means that the string is already full
        // we can add the string to the output
        if (current.length() == max * 2) {
            output.add(current);
            return;
        }

        // if the number of open parentheses is less than max, we can add "(" to the current string
        if (open < max) {
            backtrack(output, current + "(", open + 1, close, max);
        }
        // if the number of close parentheses is less than open parentheses, we can add ")" to the current string
        if (close < open) {
            backtrack(output, current + ")", open, close + 1, max);
        }
    }
}
