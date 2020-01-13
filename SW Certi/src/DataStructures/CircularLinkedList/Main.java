package DataStructures.CircularLinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList cList = new CircularLinkedList();
		
		cList.add(11);
		cList.add(22);
		cList.add(33);
		cList.add(44);
		cList.add(55);

		System.out.println("size : " + cList.size());
		System.out.println(cList.toString());
		
		System.out.println("List get : " + cList.get(3));
		
		System.out.println("List remove : " + cList.remove(3));
		System.out.println("size : " + cList.size());
		System.out.println(cList.toString());
	}

}
