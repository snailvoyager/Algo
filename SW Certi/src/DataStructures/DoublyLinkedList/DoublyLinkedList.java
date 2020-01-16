package DataStructures.DoublyLinkedList;

public class DoublyLinkedList {
	private int size = 0;
	private Node head;
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
		Node newNode = new Node(input);
		
		if(head == null) {
			head = newNode;
		} else {
			tail.next = newNode;	//새 노드의 왼쪽 연결
			newNode.prev = tail;	//새 노드의 오른쪽 연결
		}
		tail = newNode;
		
		size++;
		return true;
	}
	
	public Object get(int index) {
		Node cur = head;
		
		for(int i=0; i<index; i++) {
			cur = cur.next;
		}
		
		return cur.data;
	}
	
	public Object remove(int index) {
		Node beforeNode = head;
		Node delNode = head;
		
		for(int i=0; i<index; i++) {
			beforeNode = delNode;
			delNode = delNode.next;
		}
		beforeNode.next = delNode.next;
		delNode.next.prev = beforeNode;
		
		Object returnData = delNode.data;
		
		delNode = null;
		
		size--;
		return returnData;
	}
	
	public String toString() {
		String str = "[";
		
		Node cur = head;
		
		for(int i=0; i<size; i++) {
			if(i!=0)
				str += ", ";
			str += cur.data;
			cur = cur.next;
		}
		
		return str + "]";
	}
	
	public int size() {
		return size;
	}

}
