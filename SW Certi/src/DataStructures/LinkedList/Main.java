package DataStructures.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(55);
		
		System.out.println("List size : " + list.size());
		System.out.println(list.toString());
		
		System.out.println("List get : " + list.get(3));
		
		System.out.println("List remove : " + list.remove(3));
		System.out.println(list.toString());
		System.out.println("List size : " + list.size());
	}

}
