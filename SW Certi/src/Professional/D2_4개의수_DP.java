package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_4개의수_DP {
	static int a1, a2, a3, a4, T;
    static int[] D;					//부분집합으로 만들 수 있는 경우의 수
     
    public static int func(int n) {
        D[0] = 1;
        D[1] = 1;
         
        for(int i=2; i<=a4; i++) {
            D[i] += D[i-1];			//이전 수의 경우의 수
            if(i - a2 >=0) {
                D[i] += D[i-a2];
            }
            if(i - a3 >= 0) {
                D[i] += D[i-a3];
            }
        }
         
        return D[n];
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
                st = new StringTokenizer(br.readLine());
                a1 = Integer.parseInt(st.nextToken());
                a2 = Integer.parseInt(st.nextToken());
                a3 = Integer.parseInt(st.nextToken());
                a4 = Integer.parseInt(st.nextToken());
                 
                D = new int[a4+1];
            
            System.out.println("#"+test_case + " " + func(a4));
            System.out.println(Arrays.toString(D)); 
        }
    }
}
/*
3개의 숫자를 사용해 만든 중복순열의 합계가 4번 째 숫자와 같아지는 경우의 수를 찾아 출력하세요. 첫 번째 숫자는 항상 1입니다. 
예를 들어 1 2 3 4가 주어지면 1, 2, 3을 사용해 만든 중복 순열의 합이 4가 되는 경우의 수를 찾는 것입니다.

1+1+1+1

1+2+1

2+1+1

1+1+2

2+2

1+3

3+1

이경우 답은 7이 됩니다.

입력
테스트케이스 개수T와 다음 줄 부터 케이스별로 4개의 자연수가 주어집니다.

a1 a2 a3 a4

a1 = 1, 1<a2, a3<10, a3<a4<=20
출력
#테스트케이스와 경우의 수를 출력합니다. 

3
1 2 3 4
1 2 3 7
1 2 5 15

#1 7
#2 44
#3 1843

*/