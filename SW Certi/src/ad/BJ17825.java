package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17825 {
	static int[] Dice = new int[10];
	static Node[] node = new Node[33];
	
	static class Node{
		Node red, blue;
		int score;
		
		public Node(int score) {
			this.score = score;
			red = null;
			blue = null;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<10; i++) {
			Dice[i] = Integer.parseInt(st.nextToken());
		}
		
		node[0] = new Node(0);		
		node[1] = new Node(2);		
		node[2] = new Node(4);		
		node[3] = new Node(6);		
		node[4] = new Node(8);		
		node[5] = new Node(10);		
		
		node[21] = new Node(13);
		node[22] = new Node(16);
		node[23] = new Node(19);
		node[24] = new Node(25);
		node[25] = new Node(30);
		node[26] = new Node(35);
		
		node[0].red = node[1];
		node[1].red = node[2];
		node[2].red = node[3];
		node[3].red = node[4];
		node[4].red = node[5];
		node[5].red = node[6];	node[5].blue = node[21];
		
		node[21].red = node[22];
		node[22].red = node[23];
		node[23].red = node[24];
		node[24].red = node[25];
		node[25].red = node[26];
		
		//5번 이동
		Node n = new Node(0);
		n.red = node[0].red;
		for(int i=0; i<5; i++) {
			n = n.red;
		}
		System.out.println(n.score);
		
		//5번 노드에서 노선변경
		if(n == node[5]) {
			n.red = node[5].blue;
		}
		for(int i=0; i<5; i++) {
			n = n.red;
		}
		System.out.println(n.score);
	}

}
