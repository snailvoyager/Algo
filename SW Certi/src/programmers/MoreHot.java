package programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MoreHot {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(arr, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }

        boolean isAccept = false;
        while(pq.size() > 1) {
            /*for (int i : pq) {
                if (i < K) {    //한 음식이라도 K 미만이면 계속 진행
                    isAccept = false;
                    break;
                } else {
                    isAccept = true;
                }
            }
            if (isAccept) {     //모든 음식이 K 이상이면 끝
                return answer;
            }*/
            if (pq.peek() >= K) {   //첫 번째 음식이 K 이상이면 끝
                break;
            }
            answer++;

            int a = pq.poll();
            int b = pq.poll();
            int c = a + (b * 2);

            pq.add(c);

            System.out.println(answer + " : " + pq.toString());
        }
        if (pq.poll() < K) {
            return -1;
        }

        return answer;
    }
}
