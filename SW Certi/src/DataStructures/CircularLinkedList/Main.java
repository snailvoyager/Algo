package DataStructures.CircularLinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList cList = new CircularLinkedList();
		
		cList.addFirst(11);
		cList.addFirst(22);
		cList.addFirst(33);
		cList.addLast(44);
		cList.addLast(55);

		System.out.println("size : " + cList.size());
		System.out.println(cList.toString());
		
		System.out.println("List get : " + cList.get(3));
		
		System.out.println("List remove : " + cList.remove(3));
		System.out.println("size : " + cList.size());
		System.out.println(cList.toString());
	}

}
