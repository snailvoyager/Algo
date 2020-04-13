package ad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class BJ13460 {
    static int N, M;
    static char[][] Board, VisitRed, VisitBlue;
    static int Ri, Rj, Bi, Bj, Oi, Oj;      //좌표정보
    static int countBlue = Integer.MAX_VALUE;
    static int countRed = Integer.MAX_VALUE;

    static class Node{
        int x, y, cnt;

        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public String toString(){
            return "(" + x + "," + y + "," + cnt + ")";
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Board = new char[N][M];
        VisitRed = new char[N][M];
        VisitBlue = new char[N][M];

        for(int i=0; i<N; i++){
            String input = br.readLine();
            Board[i] = input.toCharArray();
            VisitRed[i] = input.toCharArray();
            VisitBlue[i] = input.toCharArray();
        }

        searchBoard();      //각 정점 찾기
        bfs();

        System.out.println("Red Count : " + countRed);
        System.out.println("Blue Count : " + countBlue);
        
        bw.flush();
        bw.close();

    }

    public static void searchBoard(){
        for(int i=1; i<N-1; i++){       //가장자리 생략
            for(int j=1; j<M-1; j++){
                if(Board[i][j] == 'R'){
                    Ri = i;
                    Rj = j;
                }
                if(Board[i][j] == 'B'){
                    Bi = i;
                    Bj = j;
                }
                if(Board[i][j] == 'O'){
                    Oi = i;
                    Oj = j;
                }
            }
        }
    }

    public static void bfs(){
        Deque<Node> RedQ = new ArrayDeque<Node>();
        Deque<Node> BlueQ = new ArrayDeque<Node>();

        RedQ.add(new Node(Ri, Rj, 0));
        BlueQ.add(new Node(Bi, Bj, 0));
        VisitRed[Ri][Rj] = 'X';     //시작점 체크
        VisitBlue[Bi][Bj] = 'X';

        while(!RedQ.isEmpty()){
            //System.out.println(RedQ.toString());
            Node redNode = RedQ.poll();
            int rx = redNode.x;
            int ry = redNode.y;
            int rc = redNode.cnt;

            Node blueNode = BlueQ.poll();
            int bx = 0;
            int by = 0;
            int bc = 0;

            if(blueNode != null){
                bx = blueNode.x;
                by = blueNode.y;
                bc = blueNode.cnt;
            }

            if(rc > 10){            //10번 이하로 탈출하지 못하면 종료
                countRed = -1;
                return;
            }

            

            //go up
            if(Board[rx-1][ry] != '#'){
                for(int i=rx-1; i>0; i--){
                    if(Board[i][ry] == 'O'){
                        if(countRed > rc+1){
                            countRed = rc+1;
                            System.out.println("Up RedQ");
                            break;
                        }
                    }
                    if(Board[i][ry] == 'B'){            //파란공을 만나면 멈춤
                        RedQ.add(new Node(i, ry, rc+1));
                        System.out.println("Up RedQ");
                        break;
                    }
                    if(VisitRed[i][ry] != 'X' && Board[i-1][ry] == '#'){     //방문한적 없고 다음이 벽이라면 큐에 저장
                        VisitRed[i][ry] = 'X';
                        RedQ.add(new Node(i, ry, rc+1));
                        System.out.println("Up RedQ");
                        break;
                    }
                    if(VisitRed[i][ry] == 'X'){
                        break;
                    }
                }
            }
            if(blueNode != null && Board[bx-1][by] != '#'){
                for(int i=bx-1; i>0; i--){
                    if(Board[i][by] == 'O'){
                        if(countBlue > bc+1){
                            countBlue = bc+1;
                            System.out.println("Up BlueQ");
                            break;
                        }
                    }
                    if(Board[i][by] == 'R'){        //빨간공을 만나면 멈춤
                        BlueQ.add(new Node(i, by, bc+1));
                        System.out.println("Up BlueQ");
                        break;
                    }
                    if(VisitBlue[i][by] != 'X' && Board[i-1][by] == '#'){
                        VisitBlue[i][by] = 'X';
                        BlueQ.add(new Node(i, by, bc+1));
                        System.out.println("Up BlueQ");
                        break;
                    }
                    if(VisitBlue[i][by] == 'X'){
                        break;
                    }
                }
            }
            
            //go down
            if(Board[rx+1][ry] != '#'){
                for(int i=rx+1; i<N-1; i++){
                    if(Board[i][ry] == 'O'){
                        if(countRed > rc+1){
                            countRed = rc+1;
                            System.out.println("Down Red");
                            break;
                        }
                    }
                    if(Board[i][ry] == 'B'){
                        RedQ.add(new Node(i, ry, rc+1));
                        System.out.println("Down Red");
                        break;
                    }
                    if(VisitRed[i][ry] != 'X' && Board[i+1][ry] == '#'){
                        VisitRed[i][ry] = 'X';
                        RedQ.add(new Node(i, ry, rc+1));
                        System.out.println("Down Red");
                        break;
                    }
                    if(VisitRed[i][ry] == 'X'){
                        break;
                    }
                }
            }
            if(blueNode != null && Board[bx+1][by] != '#'){
                for(int i=bx+1; i<N-1; i++){
                    if(Board[i][by] == 'O'){
                        if(countBlue > bc+1){
                            countBlue = bc+1;
                            System.out.println("Down Blue");
                            break;
                        }
                    }
                    if(Board[i][by] == 'R'){
                        BlueQ.add(new Node(i, by, bc+1));
                        System.out.println("Down Blue");
                        break;
                    }
                    if(VisitBlue[i][by] != 'X' && Board[i+1][by] == '#'){
                        VisitBlue[i][by] = 'X';
                        BlueQ.add(new Node(i, by, bc+1));
                        System.out.println("Down Blue");
                        break;
                    }
                    if(VisitBlue[i][by] == 'X'){
                        break;
                    }
                }
            }
            //go right
            if(Board[rx][ry+1] != '#'){
                for(int i=ry+1; i<M-1; i++){
                    if(Board[rx][i] == 'O'){
                        if(countRed > rc+1){
                            countRed = rc+1;
                            System.out.println("Right RedQ");
                            break;
                        }
                    }
                    if(Board[rx][i] == 'B'){
                        RedQ.add(new Node(rx, i, rc+1));
                        System.out.println("Right RedQ");
                        break;
                    }
                    if(VisitRed[rx][i] != 'X' && Board[rx][i+1] == '#'){
                        VisitRed[rx][i] = 'X';
                        RedQ.add(new Node(rx, i, rc+1));
                        System.out.println("Right RedQ");
                        break;
                    }
                    if(VisitRed[rx][i] == 'X'){
                        break;
                    }
                }
            }
            if(blueNode != null && Board[bx][by+1] != '#'){
                for(int i=by+1; i<M-1; i++){
                    if(Board[bx][i] == 'O'){
                        if(countBlue > bc+1){
                            countBlue = bc+1;
                            System.out.println("Right BlueQ");
                            break;
                        }
                    }
                    if(Board[bx][i] == 'B'){
                        BlueQ.add(new Node(bx, i, bc+1));
                        System.out.println("Right BlueQ");
                        break;
                    }
                    if(VisitBlue[bx][i] != 'X' && Board[bx][i+1] == '#'){
                        VisitBlue[bx][i] = 'X';
                        BlueQ.add(new Node(bx, i, bc+1));
                        System.out.println("Right BlueQ");
                        break;
                    }
                    if(VisitBlue[bx][i] == 'X'){
                        break;
                    }
                }
            }
            //go left
            if(Board[rx][ry-1] != '#'){
                for(int i=ry-1; i>0; i--){
                    if(Board[rx][i] == 'O'){
                        if(countRed > rc+1){
                            countRed = rc+1;
                            System.out.println("Left Red");
                            break;
                        }
                    }
                    if(Board[rx][i] == 'B'){
                        RedQ.add(new Node(rx, i, rc+1));
                        System.out.println("Left Red");
                        break;
                    }
                    if(VisitRed[rx][i] != 'X' && Board[rx][i-1] == '#'){
                        VisitRed[rx][i] = 'X';
                        RedQ.add(new Node(rx, i, rc+1));
                        System.out.println("Left Red");
                        break;
                    }
                    if(VisitRed[rx][i] == 'X'){
                        break;
                    }
                }
            }
            if(blueNode != null && Board[bx][by-1] != '#'){
                for(int i=by-1; i>0; i--){
                    if(Board[bx][i] == 'O'){
                        if(countBlue > bc+1){
                            countBlue = bc+1;
                            System.out.println("Left Blue");
                            break;
                        }
                    }
                    if(Board[bx][i] == 'R'){
                        BlueQ.add(new Node(bx, i, bc+1));
                        System.out.println("Left Blue");
                        break;
                    }
                    if(VisitBlue[bx][i] != 'X' && Board[bx][i-1] == '#'){
                        VisitBlue[bx][i] = 'X';
                        BlueQ.add(new Node(bx, i, bc+1));
                        System.out.println("Left Blue");
                        break;
                    }
                    if(VisitBlue[bx][i] == 'X'){
                        break;
                    }
                }
            }
        }
    }

}