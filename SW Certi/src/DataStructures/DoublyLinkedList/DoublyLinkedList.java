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
		Node newNode = new Node(input);
		
		if(head != null) {			//���� ��尡 ������ ��������
			newNode.next = head;
			head.prev = newNode;
		}
		head = newNode;
		
		if(head.next == null) {		//���� ��尡 ������ tail �� ����
			tail = head;
		}
		
		size++;
		return true;
	}
	
	public boolean addLast(Object input) {
		if(size == 0) {				//ù �����Ͷ�� head�� �ֱ�
			return addFirst(input);
		} else {
			Node newNode = new Node(input);
			
			tail.next = newNode;	//�� ����� ���� ����
			newNode.prev = tail;	//�� ����� ������ ����
			tail = newNode;
			
			size++;
			return true;
		}
	}
	
	public boolean add(int index, Object input) {
		if(index == 0) {
			addFirst(input);
		} else if(index == size-1) {
			addLast(input);
		} else {
			Node newNode = new Node(input);
			Node before = getNode(index - 1);
			Node next = before.next;
			
			before.next = newNode;	//�� ��� ���� ����
			newNode.prev = before;
			
			next.prev = newNode;	//�� ��� ������ ����
			newNode.next = next;
			
			size++;
		}
		
		return true;
	}
	
	public Node getNode(int index) {
		Node node = null;
		
		if(index < size / 2){	//head ���� Ž��
			node = head;
			for(int i=0; i<index; i++) {
				node = node.next;
			}
		} else {				//tail ���� Ž��
			node = tail;
			for(int i=size-1; i>index; i--) {
				node = node.prev;
			}
		}
		return node;
	}
	
	public Object get(int index) {
		Node cur = getNode(index);
		return cur.data;
	}
	
	public Object removeFirst() {
		Node delNode = head;
		Object returnData = delNode.data;
		
		head.next.prev = null;
		head = head.next;		//head ���� ���� ����
		delNode = null;
		
		size--;
		return returnData; 
	}
	
	public Object removeLast() {
		Node delNode = tail;
		Object returnData = delNode.data;
		
		tail.prev.next = null;	//tail ���� ���� ����
		tail = tail.prev;
		delNode = null;
		
		size--;
		return returnData; 
	}
	
	public Object remove(int index) {
		if(size == 0) {
			return null;
		} else if(index == 0){
			return removeFirst();
		} else if(index == size-1){
			return removeLast();
		} else {
			Node delNode = getNode(index);
			Node beforeNode = delNode.prev;
			
			beforeNode.next = delNode.next;		//���� ��� ����
			delNode.next.prev = beforeNode;		//���� ��� ����
			
			Object returnData = delNode.data;
			
			delNode = null;
			
			size--;
			return returnData;
		}
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
