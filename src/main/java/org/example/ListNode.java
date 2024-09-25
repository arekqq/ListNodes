package org.example;

public class ListNode {
    final int value;
    ListNode next;

    ListNode(int value) {
        this(value, null);
    }

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    void addLastNode(int val) {
        ListNode ln = this;
        while (ln.next != null) {
            ln = ln.next;
        }
        ln.next = new ListNode(val);
    }
}
