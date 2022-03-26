package com.project.world.algorithm;

public class MergeList {

    public static void main(String[] args) {
        ListNode listNode = ListNode.toLink(new int[]{1, 2, 4});
        ListNode listNode2 = ListNode.toLink(new int[]{1, 3, 4});

        ListNode result = new MergeList().mergeTwoLists(listNode, listNode2);
        System.out.println(result);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }

        ListNode[] sorted = sort(list1, list2);

        ListNode firstNode = sorted[0];
        ListNode currentNode = firstNode;
        while (hasNext(sorted)) {
            sorted = sort(sorted[0].next, sorted[1]);
            currentNode.next = sorted[0];
            currentNode = sorted[0];
        }
        return firstNode;
    }

    public boolean hasNext(ListNode[] nodeArray) {
        return nodeArray[0].next != null || nodeArray[1] != null;
    }

    public ListNode[] sort(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return new ListNode[]{node2, node1};
        } else if (node2 == null) {
            return new ListNode[]{node1, node2};
        } else {
            return node1.val > node2.val ? new ListNode[]{node2, node1} : new ListNode[]{node1, node2};
        }
    }
}
