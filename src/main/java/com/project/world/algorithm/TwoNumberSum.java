package com.project.world.algorithm;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class TwoNumberSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;

        ListNode resultIndex = null;

        ListNode l1Index = l1;
        ListNode l2Index = l2;

        int nextAddValue = 0;

        while (l1Index != null || l2Index != null) {

            int val1 = l1Index == null ? 0 : l1Index.val;
            int val2 = l2Index == null ? 0 : l2Index.val;

            int currentVal = val1 + val2 + nextAddValue;
            nextAddValue = 0;

            if (currentVal > 9) {
                nextAddValue = currentVal / 10;
                currentVal = currentVal % 10;
            }

            ListNode newCurrent = new ListNode(currentVal);
            if (result == null) {
                result = newCurrent;
                resultIndex = result;
            } else {
                resultIndex.next = newCurrent;
            }

            resultIndex = newCurrent;

            l1Index = l1Index == null ? null : l1Index.next;
            l2Index = l2Index == null ? null : l2Index.next;
        }

        if (nextAddValue > 0) {
            resultIndex.next = new ListNode(nextAddValue);
        }

        return result;
    }
}
