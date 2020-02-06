package ad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2667 {
	static int N;
	static char[][] M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = new char[N][N];
		
		ArrayList<Integer> result = new ArrayList<Integer>();	//�� ������ ���ϴ� ���� �� ���� ����Ʈ
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			M[i] = st.nextToken().toCharArray();
			//bw.write(Arrays.toString(M[i]) + "\n");
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(M[i][j] == '1') {
					result.add(dfs(i, j));
				}
			}
		}
		int size = result.size();
		bw.write(size + "\n");
		Collections.sort(result);
		for(int i : result)
			bw.write(i + "\n");
		
		bw.flush();
		bw.close();
	}
	
	public static int dfs(int i, int j) {
		M[i][j] = '0';		//�湮�� ���� üũ
		int n=1;
		
		if(j+1 < N && M[i][j+1] == '1')
			n += dfs(i, j+1);
		if(i+1 < N && M[i+1][j] == '1')
			n += dfs(i+1, j);
		if(j-1 > -1 && M[i][j-1] == '1')
			n += dfs(i, j-1);
		if(i-1 > -1 && M[i-1][j] == '1')
			n += dfs(i-1, j);
		
		return n;
	}

}
