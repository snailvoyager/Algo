package LeetCode.Easy;

public class LinkedListCycle {
	 class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		 }
	 
		public class Solution {
		    public boolean hasCycle(ListNode head) {
		        if(head == null)    return false;
		        
		        ListNode onestep = head;
		        ListNode twostep = head;
		        while(twostep.next != null && twostep.next.next !=null){
		            onestep = onestep.next;
		            twostep = twostep.next.next;
		            if(onestep == twostep)
		                return true;
		        }
		        
		        return false;
		    }
		}
}
