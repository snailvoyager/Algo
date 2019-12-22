import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int t = 0xfff;
		System.out.println(t);
		
		System.out.println(1<<1);
		
		Deque<Integer> deque = new ArrayDeque<Integer>();

		System.out.print("Deque Queue: ");
		deque.add(0);
		deque.add(1);
		while(!deque.isEmpty()){
			System.out.print(deque.poll()+" ");
		}
		System.out.println();
		
		PriorityQueue<Integer> pQ = new PriorityQueue<Integer>();
		pQ.add(5);
		pQ.add(2);
		while(!pQ.isEmpty()){
			System.out.print(pQ.poll() + " ");
		}
		System.out.println();

		
		System.out.print("Deque Stack: ");
		deque.push(0);
		deque.push(1);
		while(!deque.isEmpty()){
			System.out.print(deque.pop()+" ");
		}
		System.out.println();


		
		System.out.print("Array List: ");
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(0, 2);
		list.remove(0);
		for(int i : list){
			System.out.print(i+" ");
		}
		System.out.println();


		
		System.out.print("Linked List: ");
		List<Integer> lnlist = new LinkedList<Integer>();
		lnlist.add(0);
		lnlist.add(1);
		lnlist.add(0, 2);
		Iterator<Integer> iterator = lnlist.iterator();
		while(iterator.hasNext()){
			int i = iterator.next();
			System.out.print(i+" ");
		}
		System.out.println();
		
		int[] arr = new int[]{5,4,7,2,9,1};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("binarySearch : " + Arrays.binarySearch(arr, 5));
		
		arr = new int[]{5,4,7,2,9,1};
		TreeSet<Integer> bst = new TreeSet<Integer>();
		for(int key : arr)
			bst.add(key);
		System.out.println(bst);
		System.out.println(bst.contains(9));
		bst.remove(9);
		bst.add(10);
		System.out.println(bst);
		
		long l1 = 100000L;
		long l2 = 100000L;
		int intA = 1000000;
		int intB = 1000000;
		long l3 = 1L * intA * intB;
		System.out.println(l3);

	}
	
	public static long permutation(int n, int r) {
		if (r == 1) {
			return n;
		}
		return n * permutation(n - 1, r - 1);
	}

	public static long combination(int n, int r) {
		return permutation(n, r) / factorial(r);
	}

	public static long factorial(int n) {
		if (n == 1) {
			return 1;
		}

		return n * factorial(n - 1);
	}


}
