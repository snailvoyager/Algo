package DataStructures.DoublyLinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList dList = new DoublyLinkedList();
		
		dList.addLast(11);
		dList.addLast(22);
		dList.addLast(33);
		dList.addLast(44);
		dList.addLast(55);
		dList.add(3, 66);
		
		System.out.println("List size : " + dList.size());
		System.out.println(dList.toString());
		
		System.out.println("List get : " + dList.get(3));
		System.out.println("List remove : " + dList.remove(3));
		dList.remove(0);
		dList.removeLast();
		
		System.out.println("List size : " + dList.size());
		System.out.println(dList.toString());
	}

}
