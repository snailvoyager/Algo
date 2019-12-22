package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_4���Ǽ�_DP {
	static int a1, a2, a3, a4, T;
    static int[] D;					//�κ��������� ���� �� �ִ� ����� ��
     
    public static int func(int n) {
        D[0] = 1;
        D[1] = 1;
         
        for(int i=2; i<=a4; i++) {
            D[i] += D[i-1];			//���� ���� ����� ��
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
3���� ���ڸ� ����� ���� �ߺ������� �հ谡 4�� ° ���ڿ� �������� ����� ���� ã�� ����ϼ���. ù ��° ���ڴ� �׻� 1�Դϴ�. 
���� ��� 1 2 3 4�� �־����� 1, 2, 3�� ����� ���� �ߺ� ������ ���� 4�� �Ǵ� ����� ���� ã�� ���Դϴ�.

1+1+1+1

1+2+1

2+1+1

1+1+2

2+2

1+3

3+1

�̰�� ���� 7�� �˴ϴ�.

�Է�
�׽�Ʈ���̽� ����T�� ���� �� ���� ���̽����� 4���� �ڿ����� �־����ϴ�.

a1 a2 a3 a4

a1 = 1, 1<a2, a3<10, a3<a4<=20
���
#�׽�Ʈ���̽��� ����� ���� ����մϴ�. 

3
1 2 3 4
1 2 3 7
1 2 5 15

#1 7
#2 44
#3 1843

*/