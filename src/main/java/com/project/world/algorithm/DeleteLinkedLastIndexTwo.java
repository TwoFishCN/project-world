package com.project.world.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeleteLinkedLastIndexTwo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        int[] array = list.stream().mapToInt((it) -> it).toArray();
        int n = 1;
        ListNode head = ListNode.toLink(array);

        ListNode result = new DeleteLinkedLastIndexTwo().removeNthFromEnd(head, n);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();

        Integer index = 0;
        map.put(index, head);

        ListNode node = head;
        while (node.next != null) {
            index++;
            node = node.next;

            map.put(index, node);
        }

        int size = map.size();
        int deleteParentIndex = size - n - 1;

        if (deleteParentIndex < 0) {
            return head.next;
        }

        ListNode parent = map.get(deleteParentIndex);
        if (parent.next != null) {
            parent.next = parent.next.next;
        }
        return head;
    }
}
