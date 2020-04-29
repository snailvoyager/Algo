package LeetCode.Easy;

public class RemoveDuplicatesSortedList {

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while(node != null && node.next != null){
            ListNode temp = node.next;
            if(temp.val == node.val){
                node.next = temp.next;
            } else{
                node = node.next;
            }
        }
        return head;
    }
}