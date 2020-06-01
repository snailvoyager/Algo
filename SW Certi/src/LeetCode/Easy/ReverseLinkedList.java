package LeetCode.Easy;

public class ReverseLinkedList {

	
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	class Solution {
	    public ListNode reverseList(ListNode head) {
	        ListNode tail = null;

	        while(head != null){
	            ListNode node = new ListNode(head.val);
	            node.next = tail;
	            tail = node;
	            head = head.next;
	            
	        }
	        
	        return tail;
	    }
	}

}
