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
	
	public boolean addFirst(Object input) {
		Node newNode = new Node(input);
		
		if(tail == null) {			//ù��° �����
			tail = newNode;			//tail�� ����带 ����Ű�� �Ѵ�
			newNode.next = newNode;	//�� ��� �ڽ��� ����Ű�� �Ѵ�
		} else {
			newNode.next = tail.next;	//�� ����� ���� ����
			tail.next = newNode;		//�� ����� ���� ����
		}
		size++;
		return true;
	}
	
	public boolean addLast(Object input) {
		Node newNode = new Node(input);
		
		if(tail == null) {			//ù��° �����
			tail = newNode;			//tail�� ����带 ����Ű�� �Ѵ�
			newNode.next = newNode;	//�� ��� �ڽ��� ����Ű�� �Ѵ�
		} else {
			newNode.next = tail.next;	//�� ����� ���� ����
			tail.next = newNode;		//�� ����� ���� ����
			tail = newNode;				//tail�� �� ��带 ����Ű�� �Ѵ�
		}
		size++;
		return true;
	}
	
	public Object get(int index) {
		Node cur = tail.next;		//tail�� ���� ��尡 head
		
		for(int i=0; i<index; i++) {
			cur = cur.next;
		}
		
		return cur.data;
	}
	
	public Object remove(int index) {
		Node beforeNode = tail.next;	//tail�� ���� ��尡 head
		Node delNode = tail.next;
		
		for(int i=0; i<index; i++) {
			beforeNode = delNode;
			delNode = delNode.next;
		}
		
		Object returnData = delNode.data;
		
		/*if(delNode == tail) {		//���� ����� tail�� ����Ų�ٸ�
			if(tail == tail.next) {	//���� ����� ������ Ȧ�� ���� ���
				tail = null;
			} else {
				tail = beforeNode;	//tail�� ���� ��� ���� ��带 ����Ų��
			}
		}*/
		
		if(delNode == tail) {
			tail = beforeNode;
		}
		
		beforeNode.next = delNode.next;
		delNode = null;
		
		size--;
		return returnData;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String str = "[";
		Node cur = tail.next;
		
		for(int i=0; i<size; i++) {
			if(i !=0)
				str += ", ";
			str += cur.data;
			
			cur = cur.next;
		}
		
		return str + "]";
	}
}
