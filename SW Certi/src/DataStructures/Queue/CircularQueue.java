package DataStructures.Queue;

public class CircularQueue {
	private int front, rear;
	private final int QUE_LEN = 10;
	
	private Object[] queArr = new Object[QUE_LEN];
	
	public boolean isEmpty() {
		if(front == rear)		//ť�� �ֺ� ����
			return true;
		else
			return false;
	}
	
	private int nextPosIdx(int pos) {	//ť�� ���� �ε��� ��
		if(pos == QUE_LEN-1)		//�迭�� ������ �ε������
			return 0;
		else
			return ++pos;
	}
	
	public void enqueue(Object input) {
		if(nextPosIdx(rear) == front) {		//ť�� �� á�ٸ�
			System.out.println("Queue Memory Error");
		} else {
			rear = nextPosIdx(rear);	//rear ��ĭ �̵�
			queArr[rear] = input;		//rear�� ����Ű�� ���� ����
		}
	}
	
	public Object dequeue() {
		front = nextPosIdx(front);		//front�� ����Ű�� ��ġ�� ��ĭ �̵�
		Object returnData = queArr[front];
		queArr[front] = null;			//front�� ����Ű�� ������ ����
		
		return returnData;
	}
	
	public Object peek() {
		return queArr[nextPosIdx(front)];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularQueue cQueue = new CircularQueue();
		
		cQueue.enqueue(11);
		cQueue.enqueue(22);
		System.out.println(cQueue.peek());
		cQueue.enqueue(33);
		cQueue.enqueue(44);
		System.out.println(cQueue.peek());
		cQueue.enqueue(55);
		
		while(!cQueue.isEmpty()) {
			System.out.print(cQueue.dequeue() + " ");
		}
	}

}
