package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D1_이진최소힙 {
	static int T, N, index;
    static int[] Q;
     
    public static void enQ(int n) {
        int c = ++index;
        int p = c/2;
        int temp = 0;
         
        Q[c] = n;
        while(c > 1 && Q[p] > Q[c]) {
            temp = Q[p];
            Q[p] = Q[c];
            Q[c] = temp;
             
            c = p;
            p = c/2;
        }
    }
     
    public static int sumP() {
        int sum = 0;
        int c = index;
        int p = c/2;
         
        while(c > 0) {
            sum += Q[p];
            c = p;
            p = c/2;
        }
         
        return sum;
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            N = Integer.parseInt(br.readLine());
            Q = new int[N+1];
            index = 0;
             
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            for(int i=1; i<=N; i++) {
                enQ(Integer.parseInt(st.nextToken()));
            }
             
            System.out.println("#"+test_case + " " + sumP());
        }
         
         
    }
}
/*
이진 최소힙은 다음과 같은 특징을 가진다.

1. 항상 완전 이진트리를 유지한다.

2. 부모 노드의 값<=자식노드의 값을 유지한다.

3. 노드 번호는 루트가 1번, 왼쪽-오른쪽, 위-아래 순으로 1씩 증가하며 부여된다.

예를 들어 {7, 2, 5, 3, 4, 6}이 차례로 입력되면 다음과 같은 트리가 구성된다.



N개의 정수 a가 주어지면 이진 최소힙에 저장하고, 마지막 노드의 조상 노드에 저장된 정수의 합을 출력하라.

테스트케이스 개수 T가 주어지고, 테스트케이스 마다  정수의 개수 N, N 개의 정수가 차례로 주어진다.

1<=T<=10, 1<=N<=100, 1<=a<=10000

입력
1 테스트케이스 개수

6 N

7 2 5 3 4 6 N개의 정수

출력
#1 7 테스트케이스 번호, 조상 노드 데이터의 합


3
6
7 2 5 3 4 6
6
5 5 4 3 2 1
8
7 2 6 10 8 5 11 7

#1 7
#2 3
#3 16
*/