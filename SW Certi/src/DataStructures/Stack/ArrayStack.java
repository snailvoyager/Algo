package DataStructures.Stack;

public class ArrayStack {
	private int topIndex = -1;
	private Object[] stackArr = new Object[100];
	
	
	public boolean isEmpty() {
		if(topIndex == -1)
			return true;
		else
			return false;
	}
	
	public void push(Object input) {
		topIndex++;
		stackArr[topIndex] = input;
	}
	
	public Object peek() {
		return stackArr[topIndex];
	}
	
	public Object pop() {
		Object data = stackArr[topIndex];
		topIndex--;
		return data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack stack = new ArrayStack();
		stack.push(11);
		stack.push(22);
		stack.push(33);
		System.out.println(stack.peek());
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

}
