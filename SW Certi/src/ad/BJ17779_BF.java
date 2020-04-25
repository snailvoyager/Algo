package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ17779_BF {
	static int N;
	static int Answer = Integer.MAX_VALUE;
	static int[][] A, Map;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N+1][N+1];
		Map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int x=1; x<=N-2; x++) {
			for(int y=2; y<=N-1; y++) {
				for(int d1=1; d1<=N; d1++) {
					for(int d2=1; d2<=N; d2++) {
						if(x+d1+d2 > N || y+d2 > N || y-d1 < 1)
							break;
						
						Map = new int[N+1][N+1];	//Map 초기화
						Map[x][y] = 5;		//기준점
						
						//1번 경계선
						int i1 = x;
						int j1 = y;
						while(i1<=x+d1 && j1>=y-d1) {
							Map[i1][j1] = 5;
							i1++;
							j1--;
						}
						//2번 경계선
						int i2 = x;
						int j2 = y;
						while(i2<=x+d2 && j2<=y+d2) {
							Map[i2][j2] = 5;
							i2++;
							j2++;
						}
						//3번 경계선
						int i3 = x+d1;
						int j3 = y-d1;
						while(i3<=x+d1+d2 && j3<=y-d1+d2) {
							Map[i3][j3] = 5;
							i3++;
							j3++;
						}
						//4번 경계선
						int i4 = x+d2;
						int j4 = y+d2;
						while(i4<=x+d2+d1 && j4>=y+d2-d1) {
							Map[i4][j4] = 5;
							i4++;
							j4--;
						}
						
						Deque<Node> Q = new ArrayDeque<Node>();
						Q.offer(new Node(x+1, y));
						Map[x+1][y] = 5;
						
						while(!Q.isEmpty()) {			//5번 선거구 채우기
							Node n = Q.poll();
							for(int i=0; i<4; i++) {
								int xx = n.x + dx[i];
								int yy = n.y + dy[i];
								if(Map[xx][yy] == 0) {
									Map[xx][yy] = 5;
									Q.offer(new Node(xx, yy));
								}
							}
						}
						int cnt5 = 0;
						for(int i=1; i<N; i++) {
							for(int j=1; j<N; j++) {
								if(Map[i-1][j]==5 && Map[i+1][j]==5 && Map[i][j-1]==5 && Map[i][j+1]==5) {
									Map[i][j] = 5;
								}
								if(Map[i][j]==5) {
									cnt5 += A[i][j];
								}
							}
						}
						
						//1번 선거구
						int cnt1 = 0;
						for(int r=1; r<x+d1; r++) {
							for(int c=1; c<=y; c++) {
								if(Map[r][c] != 5) {
									Map[r][c] = 1;
									cnt1 += A[r][c];
								}
							}
						}
						//2번 선거구
						int cnt2 = 0;
						for(int r=1; r<=x+d2; r++) {
							for(int c=y+1; c<=N; c++) {
								if(Map[r][c] != 5) {
									Map[r][c] = 2;
									cnt2 += A[r][c];
								}
							}
						}
						//3번 선거구
						int cnt3 = 0;
						for(int r=x+d1; r<=N; r++) {
							for(int c=1; c<y-d1+d2; c++) {
								if(Map[r][c] != 5) {
									Map[r][c] = 3;
									cnt3 += A[r][c];
								}
							}
						}
						//4번 선거구
						int cnt4 = 0;
						for(int r=x+d2+1; r<=N; r++) {
							for(int c=y-d1+d2; c<=N; c++) {
								if(Map[r][c] != 5) {
									Map[r][c] = 4;
									cnt4 += A[r][c];
								}
							}
						}
						int max = Integer.max(cnt5, (Integer.max(cnt4, (Integer.max(cnt3, (Integer.max(cnt1, cnt2)))))));
						int min = Integer.min(cnt5, (Integer.min(cnt4, (Integer.min(cnt3, (Integer.min(cnt1, cnt2)))))));
						if(Answer > (max-min))
							Answer = max- min;
//						for(int i=0; i<=N; i++)
//							System.out.println(Arrays.toString(Map[i]));
						//System.out.println(cnt1 + "," + cnt2 + "," + cnt3 + "," + cnt4 +"," + cnt5+ " " + max + " " + min);
						//System.out.println();
						
					}
				}
			}
		}
		
		System.out.println(Answer);
	}

}
