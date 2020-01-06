package DataStructures.Arraylist;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(55);
		
		System.out.println("List size : " + list.size());
		System.out.println(list.toString());
		
		System.out.println("remove : " + list.remove(3));
		
		System.out.println(list.toString());
		System.out.println("Last get : " + list.get(list.size()-1));
		System.out.println("List size : " + list.size());
	}

}
