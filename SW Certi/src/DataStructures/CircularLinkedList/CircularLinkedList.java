package DataStructures.CircularLinkedList;

public class CircularLinkedList {
	private int size = 0;
	private Node tail;
	
	private class Node{
		private Object data;
		private Node next;
		
		public Node(Object input){
			this.data = input;
			this.next = null;
		}
	}
	
	public boolean add(Object input) {
		return true;
	}
	
	public Object get(int index) {
		return "";
	}
	
	public Object remove(int index) {
		return "";
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String str = "[";
		
		return str + "]";
	}
}
