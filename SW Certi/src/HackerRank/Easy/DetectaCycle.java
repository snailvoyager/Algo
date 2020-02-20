package HackerRank.Easy;

import java.util.HashSet;
import java.util.Set;

public class DetectaCycle {
	static class Node {
        int data;
        Node next;
    }
	
	boolean hasCycle(Node head) {
	    Set<Node> set = new HashSet<Node>();
	    
	    while(head != null){
	        if(!set.contains(head)){
	            set.add(head);
	            head = head.next;
	        }
	        else return true;
	    }
	    return false;
	}

}
