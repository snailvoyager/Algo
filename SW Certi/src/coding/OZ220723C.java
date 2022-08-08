package coding;

public class OZ220723C {
    //LeetCode No.1320
    class Node {
        int x;
        int y;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(String param0) {
        int answer = 0;

        char c = param0.charAt(0);
        int x = (c - 65) / 6;
        int y = (c - 65) % 6;
        Node f1 = new Node(x, y);

        c = param0.charAt(1);
        x = (c - 65) / 6;
        y = (c - 65) % 6;
        Node f2 = new Node(x, y);

        for (int i=2; i<param0.length(); i++) {
            char c2 = param0.charAt(i);
            int x2 = (c2 - 65) / 6;
            int y2 = (c2 - 65) % 6;
            Node node = new Node(x2, y2);
            int d1 = distance(f1, node);
            int d2 = distance(f2, node);

            if (d1 > d2) {
                answer += d2;
                f2 = node;
            } else {
                answer += d1;
                f1 = node;
            }

        }

        return answer;
    }

    public int distance(Node n1, Node n2) {
        return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
    }
}
