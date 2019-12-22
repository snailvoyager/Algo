package im;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deque<Integer> deque = new ArrayDeque<Integer>();

		System.out.print("Deque Queue: ");
		deque.add(0);
		deque.add(1);
		while(!deque.isEmpty()){
			System.out.print(deque.poll()+" ");
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
		
		System.out.print("Hash Map: ");
		Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		hmap.put(0, 0);
		hmap.put(1, 1);		//중복 불가
		hmap.put(1, 2);
		System.out.println(hmap);
		
		System.out.print("Hash Set: ");
		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		set.add(1);
		set.add(1);		//중복 불가
		set.add(2);
		System.out.println(set);
	}

}
