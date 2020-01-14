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
		
		if(tail == null) {			//첫번째 노드라면
			tail = newNode;			//tail이 새노드를 가리키게 한다
			newNode.next = newNode;	//새 노드 자신을 가리키게 한다
		} else {
			newNode.next = tail.next;	//새 노드의 우측 연결
			tail.next = newNode;		//새 노드의 좌측 연결
		}
		size++;
		return true;
	}
	
	public boolean addLast(Object input) {
		Node newNode = new Node(input);
		
		if(tail == null) {			//첫번째 노드라면
			tail = newNode;			//tail이 새노드를 가리키게 한다
			newNode.next = newNode;	//새 노드 자신을 가리키게 한다
		} else {
			newNode.next = tail.next;	//새 노드의 우측 연결
			tail.next = newNode;		//새 노드의 좌측 연결
			tail = newNode;				//tail이 새 노드를 가리키게 한다
		}
		size++;
		return true;
	}
	
	public Object get(int index) {
		Node cur = tail.next;		//tail의 다음 노드가 head
		
		for(int i=0; i<index; i++) {
			cur = cur.next;
		}
		
		return cur.data;
	}
	
	public Object remove(int index) {
		Node beforeNode = tail.next;	//tail의 다음 노드가 head
		Node delNode = tail.next;
		
		for(int i=0; i<index; i++) {
			beforeNode = delNode;
			delNode = delNode.next;
		}
		
		Object returnData = delNode.data;
		
		/*if(delNode == tail) {		//삭제 대상이 tail이 가리킨다면
			if(tail == tail.next) {	//삭제 대상이 마지막 홀로 남은 경우
				tail = null;
			} else {
				tail = beforeNode;	//tail이 삭제 대상 이전 노드를 가리킨다
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
