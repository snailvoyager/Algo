package DataStructures.LinkedList;

public class LinkedList {
	private int size = 0;
	private Node head;
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
		Node newNode = new Node(input);
		
		if(head == null)	//첫번째 노드라면
			head = newNode;
		else
			tail.next = newNode;
		
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
		beforeNode.next = delNode.next;	//이전 노드가 다음 노드 가리킴
		Object returnData = delNode.data;	//삭제될 데이터
		delNode = null;		//노드 삭제
		
		size--;
		return returnData;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String str = "[";
		Node cur = head;
		
		for(int i=0; i<size; i++) {
			if(i !=0)
				str += ", ";
			str += cur.data;
			
			cur = cur.next;
		}
		
		return str + "]";
	}
}
