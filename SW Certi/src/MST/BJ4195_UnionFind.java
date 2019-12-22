package MST;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BJ4195_UnionFind {
	
	static Map<String, Integer> map;
	
	static final int MAXN = 200000;
	static int[] p = new int[MAXN+1];
	static int[] r = new int[MAXN+1];
	static int[] cnt = new int[MAXN+1];
	static int N;
	
	public static void make_set(){
		for(int i=0; i<=N*2; i++){
			p[i] = i;
			r[i] = 0;
			cnt[i] = 1;
		}
	}
	
	public static int find_set(int x){
		if(x != p[x])
			p[x] = find_set(p[x]);
		return p[x];
	}
	
	public static int union(int x, int y){
		int a = find_set(x);
		int b = find_set(y);
		if(a == b) return cnt[a];
		
		if(r[a] > r[b]){
			p[b] = a;
			cnt[a] += cnt[b];
			return cnt[a];
		} else{
			p[a] = b;
			cnt[b] += cnt[a];
			if(r[a] == r[b])
				r[b]++;
			return cnt[b];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			map = new HashMap<String, Integer>();
			N = sc.nextInt();
			String key;
			Integer val;
			int id=0, u, v;
			
			make_set();
			for(int i=0; i<N; i++){
				key = sc.next();
				val = map.get(key); //map에 존재하는지 확인
				
				if(val == null){	//없으면 새로 입력
					u = id;
					map.put(key, id++);
				} else{
					u = val;
				}
				
//				System.out.println(key + " " + val);
				
				key = sc.next();	//두번째 친구 입력
				val = map.get(key);
				if(val == null){
					v = id;
					map.put(key, id++);
				} else{
					v = val;
				}
				System.out.println(union(u, v));
				
//				System.out.println(key + " " + val);
			}
			
		}
	}

}
/*
2
3
Fred Barney
Barney Betty
Betty Wilma
3
Fred Barney
Betty Wilma
Barney Betty

2
3
4
2
2
4
 */
