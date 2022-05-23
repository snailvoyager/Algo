package LeetCode.Medium;

public class PartitionList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode();
        ListNode before_head = before;

        ListNode after = new ListNode();
        ListNode after_head = after;

        while (head != null) {
            if (head.val < x) {     //less
                before.next = head;
                before = before.next;
            } else {                //greater
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;      //ending node;

        before.next = after_head.next;      //merge

        return before_head.next;
    }
}
