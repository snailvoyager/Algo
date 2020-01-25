package DataStructures.PriorityQueue;

public class Heap {
	
	private final static int HEAP_LEN = 10;
	private int size;
	private int[] heapArr = new int[HEAP_LEN]; 
	
	public int compareTo(int a, int b) {
		return a < b ? 1 : -1;				//a�� b���� �켱������ ������ 1, ���ų� ������ -1
	}
	
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public void insert(int data) {
		int idx = size + 1;		//�� ��尡 ����� �ε��� �� == ���� ������ �ܸ� ���
		
		while(idx != 1) {		//�� ��尡 ��Ʈ�� �ƴ϶��
			if(compareTo(data, heapArr[getParentIdx(idx)]) > 0) {	//�� ��尡 �θ𺸴� ���� �켱����
				heapArr[idx] = heapArr[getParentIdx(idx)];			//�θ� ��带 �� ���� ����
				idx = getParentIdx(idx);			//�� ��带 �� ���� �ø� �ε�����
			} else
				break;
		}
		heapArr[idx] = data;
		size++;
	}
	
	public int delete() {
		int removeData = heapArr[1];	//���ŵ� ��Ʈ ���
		int lastData = heapArr[size];	//������ ��� ������
		
		int parentIdx = 1;				//��Ʈ ������ ����, ������ ����� �����Ͱ� ����� ��ġ
		int childIdx = getHiPriChildIdx(parentIdx);
		
		while(childIdx != 0) {
			if(compareTo(lastData, heapArr[childIdx]) > 0) 	//�ڽĺ��� ������ ��� �켱������ ������
				break;
			
			heapArr[parentIdx] = heapArr[childIdx];			//�ڽ��� ������ ��庸�� �켱������ �����Ƿ� ����
			parentIdx = childIdx;							//������ ��尡 ����� ��ġ �� ���� ����
			childIdx = getHiPriChildIdx(parentIdx);
		}
		heapArr[parentIdx] = lastData;		//������ ��� ����
		size--;
		return removeData;
	}
	
	public int getParentIdx(int idx) {
		return idx/2;
	}
	
	public int getLeftChildIdx(int idx) {
		return idx*2;
	}
	
	public int getRightChildIdx(int idx) {
		return idx*2 + 1;
	}
	
	public int getHiPriChildIdx(int idx) {	//�ڽ� �� ���� �켱���� ��� �ε��� ��ȯ
		if(getLeftChildIdx(idx) > size)			//���� �ڽ��� ������� ũ�� == �ڽ��� �������� ������ 
			return 0;
		else if(getLeftChildIdx(idx) == size)	//���� �ڽ� �ϳ��� �����Ѵٸ�
			return getLeftChildIdx(idx);
		else {									//���� ������ �ڽ��� �����Ѵٸ�
			if(compareTo(heapArr[getLeftChildIdx(idx)], heapArr[getRightChildIdx(idx)]) > 0) {	//���� �ڽ��� ���� �켱����
				return getLeftChildIdx(idx);
			} else {											//������ �ڽ��� ���� �켱����
				return getRightChildIdx(idx);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap heap = new Heap();
		
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		
		System.out.println(heap.delete());
		System.out.println(heap.delete());
		
		heap.insert(1);
		heap.insert(2);
		heap.insert(2);
		heap.insert(4);
		heap.insert(5);
		
		while(!heap.isEmpty()) {
			System.out.println(heap.delete());
		}
	}

}
