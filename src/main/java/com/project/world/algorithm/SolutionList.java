package com.project.world.algorithm;

import java.util.HashMap;
import java.util.Map;

public class SolutionList {
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

        Integer deleteIndex = size - n;
        int deleteParentIndex = size - n - 1;

        if (deleteParentIndex < 0) {
            return head.next;
        } else {
            ListNode parent = map.get(deleteParentIndex);
            ListNode delete = map.get(deleteIndex);
            parent.next = delete.next;
            return head;
        }
    }

    public static void main(String[] args) {
        String s = "1->2->3->4->5";
        ListNode head = null;

        ListNode current = null;
        for (String s1 : s.split("->")) {
            ListNode now = new ListNode(Integer.parseInt(s1));
            if (current == null) {
                current = now;
            }
            if (head == null) {
                head = now;
            }

            current.next = now;
            current = now;
        }

        System.out.println(head);

        ListNode node = new SolutionList().removeNthFromEnd(head, 2);

        System.out.println(node);
    }
}