package com.project.world.algorithm;

public class GetLinkedMidNode {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.toLink(array);
        assert head != null;

        ListNode node = new GetLinkedMidNode().middleNode(head);
        System.out.println(node.val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode middleNode = head;
        ListNode lastNode = head.next;

        boolean haseNext = this.haseNext(lastNode);
        while (haseNext) {
            middleNode = middleNode.next;
            lastNode = lastNode.next.next;
            haseNext = this.haseNext(lastNode);
        }

        if (lastNode != null) {
            middleNode = middleNode.next;
        }
        return middleNode;
    }

    private boolean haseNext(ListNode node) {
        return  node != null && node.next != null;
    }
}