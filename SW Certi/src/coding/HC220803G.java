package coding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HC220803G {
    public static class Platformer {
        boolean[] tiles;
        int position;

        public Platformer(int n, int position) {
            this.position = position;
            tiles = new boolean[n];
            Arrays.fill(tiles, true);
        }

        public void jumpLeft() {
            int moveCnt = 0;
            int idx = this.position;
            while (moveCnt < 2) {       //매번 순회하면서 타임아웃
                idx--;
                if (tiles[idx]) {
                    moveCnt++;
                }
            }
            tiles[position] = false;
            position = idx;
        }

        public void jumpRight() {
            int moveCnt = 0;
            int idx = this.position;
            while (moveCnt < 2) {
                idx++;
                if (tiles[idx]) {
                    moveCnt++;
                }
            }
            tiles[position] = false;
            position = idx;
        }

        public int position() {
            return this.position;
        }
    }

    public static class Node {      //Doubly Linked List
        int idx;
        Node prev;
        Node next;
        public Node(int idx) {
            this.idx = idx;
        }
    }
    public static class Platformer2 {
        List<Node> tiles;
        int position;
        public Platformer2(int n, int position) {
            this.position = position;
            tiles = new LinkedList<Node>();
            for (int i=0; i<n; i++) {
                Node tile = new Node(i);

            }

        }

        public void jumpLeft() {

        }

        public void jumpRight() {

        }

        public int position() {
            return this.position;
        }
    }
    public static void main(String[] args) {
        Platformer platformer = new Platformer(6, 3);
        System.out.println(platformer.position()); // should print 3

        platformer.jumpLeft();
        System.out.println(platformer.position()); // should print 1

        platformer.jumpRight();
        System.out.println(platformer.position()); // should print 4
    }
}
