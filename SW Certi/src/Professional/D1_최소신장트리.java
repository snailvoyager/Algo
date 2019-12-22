package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D1_�ּҽ���Ʈ�� {
	static int T, V, E, Answer;
    static int[] P, R;
    static LinkedList<Edge> list;
     
    public static class Edge implements Comparable<Edge>{
        int v1, v2, w;
         
        Edge(int _v1, int _v2, int _w) {
            v1 = _v1;
            v2 = _v2;
            w = _w;
        }
         
        public int compareTo(Edge arg0) {
            // TODO Auto-generated method stub
            return w - arg0.w;
        }
    }
     
    public static void make() {
        P = new int[V+1];
        R = new int[V+1];
         
        for(int i=0; i<=V; i++) {
            P[i] = i;
            R[i] = 0;
        }
    }
     
    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
         
        if(rootA == rootB)
            return;
         
        if(R[rootA] > R[rootB]) P[rootB] = rootA;
        else{
            P[rootA] = rootB;
            if(R[rootA] == R[rootB]) R[rootB]++;
        }
    }
     
    public static int find(int x) {
        if(x != P[x])
            P[x] = find(P[x]);
         
        return P[x];
    }
     
    public static int kruskal() {
        int cost = 0;
        Collections.sort(list);
        int cnt = V - 1;
         
        while(cnt >= 0){
            Edge e = list.removeFirst();
            int a = find(e.v1);
            int b = find(e.v2);
            if(a == b) continue;
             
            union(a, b);
            cost += e.w;
             
            --cnt;
        }
         
        return cost;
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            Answer = 0;
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            list = new LinkedList<Edge>();
 
            make();
            for(int i=1; i<=E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.add(new Edge(a, b, c));
            }
             
            System.out.println("#"+test_case + " " + kruskal());
        }
    }
}
/*
0������ V�������� ��带 ���� �׷����� �ִ�. �� �׷������� �ּҽ���Ʈ���� �����ϴ� ������ ����� ��� ���� ����Ͻÿ�.

�׽�Ʈ���̽� �� T�� �־�����, �׽�Ʈ���̽� ���� ������ ����ȣ V, ������ ���� E�� E���� ������ ����  �� �� ��� n1, n2�� ��� w�� ���ʷ� �־�����.

1<=T<=10

1<=V<=1000, 1<=w<=10, 1<=E<=1000000

�Է�
1

2 3

0 1 1
0 2 1
1 2 6
���
#1 2

3
2 3
0 1 1
0 2 1
1 2 6
4 7
0 1 9
0 2 3
0 3 7
1 4 2
2 3 8
2 4 1
3 4 8
4 6
0 1 10
0 2 7
1 4 2
2 3 10
2 4 3
3 4 10

#1 2
#2 13
#3 22

*/