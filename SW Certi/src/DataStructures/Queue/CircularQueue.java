package DataStructures.Queue;

public class CircularQueue {
	private int front, rear;
	private final int QUE_LEN = 10;
	
	private Object[] queArr = new Object[QUE_LEN];
	
	public boolean isEmpty() {
		if(front == rear)		//큐가 텅빈 상태
			return true;
		else
			return false;
	}
	
	private int nextPosIdx(int pos) {	//큐의 다음 인덱스 값
		if(pos == QUE_LEN-1)		//배열의 마지막 인덱스라면
			return 0;
		else
			return ++pos;
	}
	
	public void enqueue(Object input) {
		if(nextPosIdx(rear) == front) {		//큐가 꽉 찼다면
			System.out.println("Queue Memory Error");
		} else {
			rear = nextPosIdx(rear);	//rear 한칸 이동
			queArr[rear] = input;		//rear가 가리키는 곳에 저장
		}
	}
	
	public Object dequeue() {
		front = nextPosIdx(front);		//front가 가리키는 위치를 한칸 이동
		Object returnData = queArr[front];
		queArr[front] = null;			//front가 가리키는 데이터 삭제
		
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
