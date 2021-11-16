package LeetCode.Medium;

public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(head.next.val, head);

        ListNode temp = new ListNode();
        temp.next = swapPairs(head.next.next);
        head.next.next = head;
        head.next = temp.next;

        return newHead;
    }
}
