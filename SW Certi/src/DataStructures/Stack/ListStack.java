package DataStructures.Stack;

public class ListStack {
	private int size = 0;
	private Node head;
	
	private class Node{
		private Object data;
		private Node prev;
		
		public Node(Object input) {
			this.data = input;
			this.prev = null;
		}
	}
	
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public void push(Object input) {
		Node newNode = new Node(input);
		newNode.prev = head;	//���ο� ��� ����
		head = newNode;			//head�� ���ο� ��带 ����Ŵ
		size++;
	}
	
	public Object peek() {
		return head.data;
	}
	
	public Object pop() {
		Node delNode = head;
		Object data = head.data;
		head = delNode.prev;	//head ����
		delNode = null;
		size--;
		return data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListStack stack = new ListStack();
		
		stack.push(11);
		stack.push(22);
		stack.push(33);
		
		System.out.println(stack.peek());
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

}
