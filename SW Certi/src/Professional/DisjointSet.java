package Professional;
import java.util.Arrays;

public class DisjointSet {

	static int[] p;
	static int[] r;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		make_set(10);
		print_set();
		
		union_set(1, 3);
		union_set(2, 10);
		union_set(7, 5);
		union_set(3, 7);
		union_set(2, 8);
		union_set(1, 9);
		
		System.out.println("연산>");
		
		print_set();
		
	}

	public static void make_set(int n){
		p = new int[n+1];
		r = new int[n+1];
		
		for(int i=1; i<=n; i++){
			p[i] = i;
			r[i] = 0;
		}
	}
	
	public static int find_set(int x){
		if(x != p[x])
			p[x] = find_set(p[x]);
		
		return p[x];
	}
	
	public static void union_set(int x, int y){
		int a = find_set(x);
		int b = find_set(y);
		
		if(a == b) return;
		
		if(r[a] > r[b])
			p[b] = a;
		else{
			p[a] = b;
			if(r[a] == r[b]) r[b]++;
		}
	}
	
	public static void print_set(){
		System.out.println("부모 : " + Arrays.toString(p));
		System.out.println("랭크 : " + Arrays.toString(r));
	}
}
