package org.example;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: (7 -> 0 -> 8)
The list is represented as nodes of the following class:

class ListNode {
    final int value;
    ListNode next;
    ListNode(int value) {
        this(value, null);
    }
    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
 */

import java.util.Objects;

public class Main {
    public static void main(String[] args) {


        var ln1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        var ln2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        var result = calculateSum(ln1, ln2);

        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }

    }

    private static ListNode calculateSum(ListNode ln1, ListNode ln2) {

        int mem = 0;
        ListNode result = null;
        do {
            int ln1Val = ln1 != null ? ln1.value : 0;
            int ln2Val = ln2 != null ? ln2.value : 0;
            int sum = ln1Val + ln2Val + mem;

            if (sum >= 10) {
                sum = sum % 10;
                mem = 1;
            } else {
                mem = 0;
            }

            if (result != null) {
                result.addLastNode(sum);
            } else {
                result = new ListNode(sum);
            }
            ln1 = ln1.next;
            ln2 = ln2.next;
        } while (Objects.nonNull(ln1) || Objects.nonNull(ln2));
        return result;
    }

}