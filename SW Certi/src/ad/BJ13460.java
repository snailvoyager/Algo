package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ13460 {
    static int N, M;
    static char[][] Board;
    static boolean[][][][] Visit = new boolean[10][10][10][10];
    static int Ri, Rj, Bi, Bj, Oi, Oj;

    static class Node{
        int ri, rj, bi, bj, cnt;
        
        public Node(int ri, int rj, int bi, int bj, int cnt) {
        	this.ri = ri;
        	this.rj = rj;
        	this.bi = bi;
        	this.bj = bj;
        	this.cnt = cnt;
        }
        
        public String toString(){
            return "("+ ri + "," + rj + ") (" + bi+ "," + bj + ") " + cnt;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Board = new char[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            Board[i] = str.toCharArray();
            for(int j=0; j<str.length(); j++) {		//구슬, 구멍 정점찾기
            	if(str.charAt(j) == 'R') {
            		Ri = i;
            		Rj = j;
            	}
            	if(str.charAt(j) == 'B') {
            		Bi = i;
            		Bj = j;
            	}
            	if(str.charAt(j) == 'O') {
            		Oi = i;
            		Oj = j;
            	}
            }
        }
        
        bfs(new Node(Ri, Rj, Bi, Bj, 0));
        
    }
    
    public static void bfs(Node n) {
    	Deque<Node> q = new ArrayDeque<Node>();
    	q.offer(n);
    	//System.out.println(q.toString());
    	Visit[Ri][Rj][Bi][Bj] = true;
    	
    	while(!q.isEmpty()) {
    		Node p = q.poll();
    		
    		if(p.cnt > 10) {		//10번 넘으면 종료
    			System.out.println(-1);
    			return;
    		}
    		
    		//위로 파란공부터
    		int ri = p.ri;
    		int rj = p.rj;
    		int bi = p.bi;
    		int bj = p.bj;
    		
    		while(bi >= 0) {
    			if(Board[bi][bj] == 'O') {		//구멍을 만나면
    				System.out.println(-1);		//파란공이 먼저 빠지거나 동시에 빠지는 경우
    				return;
    			}
    			if(Board[bi][bj] == '#') {		//울타리를 만나면
        			++bi;						//올라가다가 울타리를 만나면 한칸 아래로
    				break;
        		}
    			bi--;
    		}
    		//위로 빨간공
    		while(ri >= 0) {
    			if(Board[ri][rj] == 'O') {
    				System.out.println(p.cnt+1);	//빨간공 탈출
    				return;
    			}
    			if(Board[ri][rj] == '#') {
    				++ri;
    				break;
    			}
    			ri--;
    		}
    		if((ri==bi) && (rj==bj)) {		//빨간, 파란 구슬 위치가 같다면 위치조정
				if(p.ri > p.bi) {		//빨간공이 더 멀었으면 한칸 밑으로
					++ri;
				} else {
					++bi;				//파란공이 더 멀었으면 한칸 밑으로
				}
			}
    		if(!Visit[ri][rj][bi][bj]) {	//방문한적이 없으면
    			Visit[ri][rj][bi][bj] = true;
    			q.offer(new Node(ri, rj, bi, bj, p.cnt+1));
    		}
    		
    		//아래로 파란공
    		ri = p.ri;
    		rj = p.rj;
    		bi = p.bi;
    		bj = p.bj;
    		
    		while(bi < N) {
    			if(Board[bi][bj] == 'O') {
    				System.out.println(-1);
    				return;
    			}
    			if(Board[bi][bj] == '#') {
    				--bi;
    				break;
    			}
    			bi++;
    		}
    		//아래로 빨간공
    		while(ri < N) {
    			if(Board[ri][rj] == 'O') {
    				System.out.println(p.cnt+1);
    				return;
    			}
    			if(Board[ri][rj] == '#') {
    				--ri;
    				break;
    			}
    			ri++;
    		}
    		if(ri==bi && rj==bj) {
    			if(p.ri > p.bi) {
    				--bi;
    			} else
    				--ri;
    		}
    		if(!Visit[ri][rj][bi][bj]) {
    			Visit[ri][rj][bi][bj] = true;
    			q.offer(new Node(ri, rj, bi, bj, p.cnt+1));
    		}
    		
    		//우로 파란공
    		ri = p.ri;
    		rj = p.rj;
    		bi = p.bi;
    		bj = p.bj;
    		
    		while(bj < M) {
    			if(Board[bi][bj] == 'O') {
    				System.out.println(-1);
    				return;
    			}
    			if(Board[bi][bj] == '#') {
    				--bj;
    				break;
    			}
    			bj++;
    		}
    		//우로 빨간공
    		while(rj < M) {
    			if(Board[ri][rj] == 'O') {
    				System.out.println(p.cnt+1);
    				return;
    			}
    			if(Board[ri][rj] == '#') {
    				--rj;
    				break;
    			}
    			rj++;
    		}
    		if(ri==bi && rj==bj) {
    			if(p.rj > p.bj) {
    				--bj;
    			}else
    				--rj;
    		}
    		if(!Visit[ri][rj][bi][bj]) {
    			Visit[ri][rj][bi][bj] = true;
    			q.offer(new Node(ri, rj, bi, bj, p.cnt+1));
    		}
    		
    		//좌로 파란공
    		ri = p.ri;
    		rj = p.rj;
    		bi = p.bi;
    		bj = p.bj;
    		
    		while(bj >= 0) {
    			if(Board[bi][bj] == 'O') {
    				System.out.println(-1);
    				return;
    			}
    			if(Board[bi][bj] == '#') {
    				++bj;
    				break;
    			}
    			bj--;
    		}
    		
    		//좌로 빨간공
    		while(rj >= 0) {
    			if(Board[ri][rj] == 'O') {
    				System.out.println(p.cnt+1);
    				return;
    			}
    			if(Board[ri][rj] == '#') {
    				++rj;
    				break;
    			}
    			rj--;
    		}
    		if(ri==bi && rj==bj) {
    			if(p.rj > p.bj) {
    				++rj;
    			} else
    				++bj;
    		}
    		if(!Visit[ri][rj][bi][bj]) {
    			Visit[ri][rj][bi][bj] = true;
    			q.offer(new Node(ri, rj, bi, bj, p.cnt+1));
    		}
    		
    		
    	}
    	System.out.println(-1);
		return;
    }

}