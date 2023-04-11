package com.fajarmf.leetcode.addtwonumbers;

public class AddTwoNumbers {
    public static void main(String[] args) {
      /*
      You are given two non-empty linked lists representing two non-negative integers.
      The digits are stored in reverse order, and each of their nodes contains a single digit.
      Add the two numbers and return the sum as a linked list.
      You may assume the two numbers do not contain any leading zero, except the number 0 itself.
      */
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result.val + " -> " + result.next.val + " -> " + result.next.next.val);
    }

    /*
        Explanation:
        1. Create a new ListNode as a result.
        2. Create a new ListNode as a current.
        3. Create a variable to store the carry.
        4. Loop through the list until both list is null.
        5. Sum the value of the list and the carry.
        6. Set the carry to the sum divided by 10.
        7. Set the next value of the current to the sum mod 10.
        8. Set the current to the next value.
        9. If the carry is greater than 0, set the next value of the current to the carry.
        10. Return the next value of the result.
    */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return result.next;
    }
}
