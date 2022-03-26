package LeetCode.Easy;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;

        ListNode f = head;
        ListNode prev = new ListNode(f.val, null);

        while (f.next != null) {
            f = f.next;
            ListNode node = new ListNode(f.val, prev);
            prev = node;
        }

        while (head.next != null) {
            if (head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head.next == null) {
            return true;
        }

        ListNode f = head, s = head;
        while (f != null && f.next != null) {       //List 중간 값 계산
            f = f.next.next;
            s = s.next;
        }

        if (f != null) {
            s = s.next;     //ListNode가 홀수 일때 중간 값 한칸 더 이동
        }

        //중간 값 부터 Reverse
        ListNode prev = null;
        /*while (s != null) {
            ListNode node = new ListNode(s.val, prev);      //메모리 낭비
            prev = node;
            s = s.next;
        }*/
        while (s != null) {
            ListNode next = s.next;
            s.next = prev;
            prev = s;
            s = next;
        }

        while (prev != null) {
            if (head.val != prev.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }

        return true;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}