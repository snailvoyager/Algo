package DataStructures.PriorityQueue;

public class Heap {
	
	private final static int HEAP_LEN = 10;
	private int size;
	private int[] heapArr = new int[HEAP_LEN]; 
	
	public int compareTo(int a, int b) {
		return a < b ? 1 : -1;				//a가 b보다 우선순위가 높으면 1, 같거나 낮으면 -1
	}
	
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public void insert(int data) {
		int idx = size + 1;		//새 노드가 저장될 인덱스 값 == 가장 마지막 단말 노드
		
		while(idx != 1) {		//새 노드가 루트가 아니라면
			if(compareTo(data, heapArr[getParentIdx(idx)]) > 0) {	//새 노드가 부모보다 높은 우선순위
				heapArr[idx] = heapArr[getParentIdx(idx)];			//부모 노드를 한 레벨 내림
				idx = getParentIdx(idx);			//새 노드를 한 레벨 올림 인덱스만
			} else
				break;
		}
		heapArr[idx] = data;
		size++;
	}
	
	public int delete() {
		int removeData = heapArr[1];	//제거될 루트 노드
		int lastData = heapArr[size];	//마지막 노드 데이터
		
		int parentIdx = 1;				//루트 노드부터 시작, 마지막 노드의 데이터가 저장될 위치
		int childIdx = getHiPriChildIdx(parentIdx);
		
		while(childIdx != 0) {
			if(compareTo(lastData, heapArr[childIdx]) > 0) 	//자식보다 마지막 노드 우선순위가 높으면
				break;
			
			heapArr[parentIdx] = heapArr[childIdx];			//자식이 마지막 노드보다 우선순위가 높으므로 변경
			parentIdx = childIdx;							//마지막 노드가 저장될 위치 한 레벨 내림
			childIdx = getHiPriChildIdx(parentIdx);
		}
		heapArr[parentIdx] = lastData;		//마지막 노드 저장
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
	
	public int getHiPriChildIdx(int idx) {	//자식 중 높은 우선순위 노드 인덱스 반환
		if(getLeftChildIdx(idx) > size)			//왼쪽 자식이 사이즈보다 크면 == 자식이 존재하지 않으면 
			return 0;
		else if(getLeftChildIdx(idx) == size)	//왼쪽 자식 하나만 존재한다면
			return getLeftChildIdx(idx);
		else {									//왼쪽 오른쪽 자식이 존재한다면
			if(compareTo(heapArr[getLeftChildIdx(idx)], heapArr[getRightChildIdx(idx)]) > 0) {	//왼쪽 자식이 높은 우선순위
				return getLeftChildIdx(idx);
			} else {											//오른쪽 자식이 높은 우선순위
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
