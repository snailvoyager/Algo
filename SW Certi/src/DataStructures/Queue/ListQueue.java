package DataStructures.Queue;

public class ListQueue {
	private Node front;
	private Node rear;
	
	private class Node{
		Object data;
		Node next;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
	}
	
	public boolean isEmpty() {
		if(front == null)
			return true;
		else
			return false;
	}
	
	public void enqueue(Object input) {
		Node newNode = new Node(input);
		if(isEmpty()) {				//ù��° ��� �߰�
			front = newNode;
			rear = newNode;
		} else {					//�ι�° ��� �߰�
			rear.next = newNode;	//���� ��� ����
			rear = newNode;			//rear ����
		}
	}
	
	public Object peek() {
		return front.data;
	}
	
	public Object dequeue() {
		Node delNode = front;
		Object returnData = front.data;
		front = front.next;			//front ����
		delNode = null;				//��� ����
		return returnData;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListQueue lQ = new ListQueue();
		
		lQ.enqueue(11);
		lQ.enqueue(22);
		System.out.println(lQ.peek());
		lQ.enqueue(33);
		lQ.enqueue(44);
		lQ.enqueue(55);
		
		while(!lQ.isEmpty()) {
			System.out.print(lQ.dequeue() + " ");
		}
	}

}
