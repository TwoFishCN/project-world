package com.project.world.algorithm;

public class DeleteLinkedLastIndex {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2};
        int n = 1;
        ListNode head = ListNode.toLink(array);

        ListNode result = new DeleteLinkedLastIndex().removeNthFromEnd(head, n);

        ListNode current = result;

        System.out.println(current);
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode removeNodeParent = head;
        ListNode currentNode = head;
        for (int i = 0; i < n; i++) {
            currentNode = currentNode.next;
        }

        while (hasNext(currentNode)) {
            removeNodeParent = removeNodeParent.next;
            currentNode = currentNode.next;
        }

        if (removeNodeParent.next == null) {
            return null;
        }
        if (currentNode == null) {
            return head.next;
        }

        removeNodeParent.next = removeNodeParent.next.next;
        return head;
    }

    private boolean hasNext(ListNode node) {
        return node != null && node.next != null;
    }
}
