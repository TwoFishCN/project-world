package com.project.world.algorithm;

public class RevertLinkList {

    public static void main(String[] args) {
        ListNode head = ListNode.toLink(new int[]{1, 2, 3, 4, 5});
        ListNode node = new RevertLinkList().reverseList(head);
        System.out.println(node);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        ListNode there = second.next;

        first.next = null;
        second.next = first;
        while (there != null) {
            first = second;
            second = there;
            there = there.next;

            second.next = first;
        }

        return second;
    }
}
