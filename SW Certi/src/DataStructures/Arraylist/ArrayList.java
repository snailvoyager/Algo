package DataStructures.Arraylist;

public class ArrayList {
	private int size = 0;
	private Object[] arrData = new Object[100];
	
	public boolean add(Object object) {
		if(size >= 100) {
			System.out.println("저장 불가");
			return false;
		}
		arrData[size] = object;
		size++;
		
		return true;
	}
	
	public Object get(int index) {
		return arrData[index];
	}
		
	public Object remove(int index) {
		Object removed = arrData[index];
		for(int i=index+1; i<size; i++) {
			arrData[i-1] = arrData[i];
		}
		size--;
		arrData[size] = null;
		
		return removed;
	}
	
	public int size() {
		return this.size;
	}
	
	public String toString() {
		String str = "[";
		
		for(int i=0; i<size; i++) {
			str += arrData[i];
			if(i < size-1)
				str += ",";
		}
		
		return str + "]";
	}
}
