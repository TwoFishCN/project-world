package com.project.world.algorithm;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode toLink(int[] array) {
        if (array.length < 1) {
            return null;
        }

        ListNode head = new ListNode(array[0]);
        ListNode parentNode = head;
        for (int i = 1; i < array.length; i++) {
            ListNode currentNode = new ListNode(array[i]);
            parentNode.next = currentNode;
            parentNode = currentNode;
        }
        return head;
    }
}
