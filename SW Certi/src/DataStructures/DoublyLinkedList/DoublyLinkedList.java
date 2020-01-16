package DataStructures.DoublyLinkedList;

public class DoublyLinkedList {
	private int size = 0;
	private Node tail;
	
	private class Node{
		private Object data;
		private Node next;
		private Node prev;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
			this.prev = null;
		}
	}
	
	public boolean addFirst(Object input) {
		return true;
	}
	
	public boolean addLast(Object input) {
		return true;
	}
	
	public String toString() {
		String str = "[";
		
		return str + "]";
	}
	
	public int size() {
		return size;
	}

}
