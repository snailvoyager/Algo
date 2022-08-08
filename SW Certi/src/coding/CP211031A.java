package coding;

public class CP211031A {
    public static void main(String[] args) {
        int[][] delivery = {{1,3,1},{3,5,0},{5,4,0},{2,5,0}};
        System.out.println(solution(6, delivery));
    }

    public static String solution(int n, int[][] delivery) {
        char[] deliveryYn = new char[n+1];
        for (int i=0; i<n+1; i++) {     //알수없음 초기화
            deliveryYn[i] = '?';
        }

        for (int i=0; i<delivery.length; i++) {
            if (delivery[i][2] == 1) {      // 배송 가능
                deliveryYn[delivery[i][0]] = 'O';
                deliveryYn[delivery[i][1]] = 'O';
            }
        }

        for (int i=0; i<delivery.length; i++) {
            if (delivery[i][2] == 0) {      // 배송 불가
                if (deliveryYn[delivery[i][0]] == 'O') {       //1번이 가능이면 2번이 불가
                    deliveryYn[delivery[i][1]] = 'X';
                }
                if (deliveryYn[delivery[i][1]] == 'O') {       //2번이 가능이면 1번이 불가
                    deliveryYn[delivery[i][0]] = 'X';
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i=1; i<deliveryYn.length; i++) {
            answer.append(deliveryYn[i]);
        }

        return answer.toString();
    }
}
