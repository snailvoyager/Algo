package LeetCode.Easy;

public class MergeTwoSortedLists{
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode post = list;
        
        while(l1 != null || l2 != null){
            if(l2 == null || (l1 != null && l1.val <= l2.val)){
                ListNode newNode = new ListNode(l1.val);
                post.next = newNode;
                post = post.next;
                l1 = l1.next;   //l1 이동
            } else{
                ListNode newNode = new ListNode(l2.val);
                post.next = newNode;
                post = post.next;
                l2 = l2.next;   //l2 이동
            }
        }
        
        return list.next;
    }
}