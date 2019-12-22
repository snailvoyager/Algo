package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1_그룹나누기_DisjointSet {
	static int N, M, T;
    static int[] A;
    static int Answer;
     
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
         
        A[b] = rootA;
    }
     
    public static int find(int n) {
        while(A[n] != n)
            n = A[n];
         
        return n;
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N+1];
             
            for(int i=1; i<=N; i++) {    //루트노드 초기화
                A[i] = i;
            }
             
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=M; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
             
            Answer = 0;
            for(int i=1; i<=N; i++) {
                if(A[i] == i)
                    Answer++;
            }
             
            System.out.println("#"+test_case + " " + Answer);
        }
    }
}
/*
야외활동에서 같은 조를 만들고 싶은 사람끼리 출석번호를 종이에 적어 제출하였다. 1번부터 N번까지 빠진 번호가 없고, 제출한 종이는 모두 M장이었다. 
특별히 같은 조가 되고 싶은 사람이 없으면 종이를 제출하지 않았기 때문에 종이에 번호가 없는 경우도 있고, 
여러 명과 한 조가 되고 싶어 여러 장의 종이를 제출하거나, 여러 명이 한 친구를 적어낸 경우도 있다. 
혼자인 경우도 1조로 계산한다면 모두 몇 개의 조가 만들어지는지 출력하라.

2<=N<=100, 1<=M<=1000

입력
테스트케이스 수, N, M, M개의 종이에 적힌 두 사람의 번호가 차례로 주어진다.
출력
#뒤에 테스트케이스 번호, 몇 개의 조가 만들어지는지 출력한다.

3
5 2
1 2 3 4
5 3
1 2 2 3 4 5
7 4
2 3 4 5 4 6 4 7

#1 3
#2 2
#3 3
*/