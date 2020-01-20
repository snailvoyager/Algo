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
		
		if(isEmpty()) {					//����ִٸ�
			tail = newNode;				//tail ����
		} else {
			head.prev = newNode;		//�� ��� ����
		}
		head = newNode;					//head ����
	}
	
	public void addLast(Object input) {
		Node newNode = new Node(input);
		
		if(isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;			//�� ��� ������ ����
			newNode.prev = tail;			//�� ��� ���� ����
			tail = newNode;					//tail ����
		}
	}
	
	public Object removeFirst() {
		Node delNode = head;
		Object returnData = delNode.data;
		
		head = head.next;			//head ����
		
		if(head == null) {			//����� head�� ���ٸ�
			tail = null;			//�ƹ��͵� �����ϱ� tail�� null
		} else {
			head.prev = null;
		}
		delNode = null;
		
		return returnData;
	}
	
	public Object removeLast() {
		Node delNode = tail;
		Object returnData = delNode.data;
		
		tail = tail.prev;			//tail ����
		
		if(tail == null) {			//����� tail�� ���ٸ�
			head = null;			//�ƹ��͵� �����ϱ� head�� null
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
