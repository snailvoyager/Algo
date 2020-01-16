package DataStructures.DoublyLinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList dList = new DoublyLinkedList();
		
		dList.addFirst(11);
		dList.addFirst(22);
		dList.addFirst(33);
		dList.addLast(44);
		dList.addLast(55);
		
		System.out.println("List size : " + dList.size());
		System.out.println(dList.toString());
		
		System.out.println("List get : ");
		System.out.println("List remove : ");
		
		System.out.println("List size : " + dList.size());
		System.out.println(dList.toString());
	}

}
