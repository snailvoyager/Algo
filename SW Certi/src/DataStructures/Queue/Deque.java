package DataStructures.Queue;

public class Deque {
	private Node head;
	private Node tail;
	
	private class Node{
		Object data;
		Node next;
		Node prev;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
			this.prev = null;
		}
	}
	
	public boolean isEmpty() {
		if(head == null)
			return true;
		else
			return false;
	}
	
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		
		if(isEmpty()) {					//비어있다면
			tail = newNode;				//tail 연결
		} else {
			head.prev = newNode;		//새 노드 연결
		}
		head = newNode;					//head 변경
	}
	
	public void addLast(Object input) {
		Node newNode = new Node(input);
		
		if(isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;			//새 노드 오른쪽 연결
			newNode.prev = tail;			//새 노드 왼쪽 연결
			tail = newNode;					//tail 변경
		}
	}
	
	public Object removeFirst() {
		Node delNode = head;
		Object returnData = delNode.data;
		
		head = head.next;			//head 변경
		
		if(head == null) {			//변경된 head가 없다면
			tail = null;			//아무것도 없으니까 tail도 null
		} else {
			head.prev = null;
		}
		delNode = null;
		
		return returnData;
	}
	
	public Object removeLast() {
		Node delNode = tail;
		Object returnData = delNode.data;
		
		tail = tail.prev;			//tail 변경
		
		if(tail == null) {			//변경된 tail이 없다면
			head = null;			//아무것도 없으니까 head도 null
		} else {
			tail.next = null;
		}
		delNode = null;
		
		return returnData;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque dq = new Deque();
		
		dq.addFirst(33);
		dq.addFirst(22);
		dq.addFirst(11);
		
		dq.addLast(44);
		dq.addLast(55);
		dq.addLast(66);
		
		while(!dq.isEmpty()) {
			System.out.print(dq.removeFirst() + " ");
		}
		System.out.println();
		
		dq.addFirst(33);
		dq.addFirst(22);
		dq.addFirst(11);
		
		dq.addLast(44);
		dq.addLast(55);
		dq.addLast(66);
		
		while(!dq.isEmpty()) {
			System.out.print(dq.removeLast() + " ");
		}
		System.out.println();
	}

}
