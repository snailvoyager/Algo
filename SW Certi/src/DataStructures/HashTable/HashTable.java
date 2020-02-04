package DataStructures.HashTable;

public class HashTable {
	
	static class Person{
		private int empno;
		private String name;
		
		Person(int empno, String name){
			this.empno = empno;
			this.name = name;
		}
		
		public int getEmpno() {
			return this.empno;
		}
		
		public String toString() {
			return "��� : " + this.empno + " " + "�̸� : " + this.name;
		}
	}
	
	static class Slot{
		int key;
		Person value;
		SlotStatus status;
	}
	
	public enum SlotStatus{EMPTY, DELETED, INUSE}
	
	static class Table{
		Slot[] tbl;			//�����Ͱ� ����Ǵ� ���� ���̺�
		
		Table(){
			tbl = new Slot[100];
			
			for(int i=0; i<100; i++) {
				tbl[i] = new Slot();
				tbl[i].status = SlotStatus.EMPTY;
			}
		}
		
		public int hashcode(int key) {
			return key % 100;
		}
		
		public void put(int key, Person value) {
			int hv = hashcode(key);			//�콬�ڵ� ��ȯ
			this.tbl[hv].value = value;
			this.tbl[hv].key = key;
			this.tbl[hv].status = SlotStatus.INUSE;
		}
		
		public Person remove(int key) {
			int hv = hashcode(key);
			if(this.tbl[hv].status != SlotStatus.INUSE)
				return null;
			else {
				this.tbl[hv].status = SlotStatus.DELETED;	//�浹�� �ذ�å�� ���� ���Ի��� Deleted ����
				return this.tbl[hv].value;
			}
		}
		
		public Person get(int key) {
			int hv = hashcode(key);
			if(this.tbl[hv].status != SlotStatus.INUSE)
				return null;
			else
				return this.tbl[hv].value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table table = new Table();
		
		Person kim = new Person(20200003, "Kim");
		Person hwang = new Person(20200012, "Hwang");
		
		table.put(kim.getEmpno(), kim);
		table.put(hwang.getEmpno(), hwang);
		
		Person searchP = table.get(20200012);
		System.out.println(searchP.toString());
		
		System.out.println(table.remove(20200012).toString());
		
		Person park = new Person(20200103, "Park");		//�ؽ��ڵ� �浹 ������
		table.put(park.getEmpno(), park);
		
		searchP = table.get(20200003);
		System.out.println(searchP.toString());
		
	}

}
