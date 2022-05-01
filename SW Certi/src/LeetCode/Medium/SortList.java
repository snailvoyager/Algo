package LeetCode.Medium;

public class SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList_selection(ListNode head) {     //selection sort O(N^2)
        if (head == null)
            return null;

        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode minNode = null;
            int minVal = currentNode.val;

            ListNode node = currentNode.next;
            while (node != null) {
                if (minVal > node.val) {
                    minNode = node;
                    minVal = node.val;
                }
                node = node.next;
            }
            if (minNode != null) {
                int temp = currentNode.val;
                currentNode.val = minNode.val;
                minNode.val = temp;
            }

            currentNode = currentNode.next;
        }

        return head;
    }

    public ListNode sortList(ListNode head) {
        ListNode sortedList = mergeSort(head);
        return sortedList;
    }

   public ListNode mergeSort(ListNode h) {
        if (h == null || h.next == null) {
            return h;
        }

        ListNode midNode = getMidNode(h);
        ListNode nextOfMid = midNode.next;  //가운데 우측 시작
        midNode.next = null;    // 가운데 자르기

        ListNode left = mergeSort(h);
        ListNode right = mergeSort(nextOfMid);

        ListNode sortedList = sortMerge(left, right);
        return sortedList;
    }

    public ListNode getMidNode(ListNode h) {
        if (h == null) {
            return h;
        }
        ListNode slow = h, fast = h;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode sortMerge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null ) {
            return a;
        }
        ListNode result;
        if (a.val < b.val) {
            result = a;
            result.next = sortMerge(a.next, b);
        } else {
            result = b;
            result.next = sortMerge(b.next, a);
        }
        return result;
    }
}
