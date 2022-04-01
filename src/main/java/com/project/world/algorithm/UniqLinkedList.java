package com.project.world.algorithm;

import java.util.HashMap;

public class UniqLinkedList {

    public static void main(String[] args) {
        final ListNode head = ListNode.toLink(new int[]{1,1,2, 2});
        ListNode node = new UniqLinkedList().deleteDuplicates(head);
        System.out.println(node);
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
