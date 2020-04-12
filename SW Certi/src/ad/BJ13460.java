package ad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ13460 {
    static int N, M;
    static char[][] Board;
    static int Ri, Rj, Bi, Bj, Oi, Oj;      //좌표정보
    static int countBlue = Integer.MAX_VALUE;

    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Board = new char[N][M];

        for(int i=0; i<N; i++){
            Board[i] = br.readLine().toCharArray();
            //System.out.println(Arrays.toString(B[i]));
        }

        searchBoard();      //각 정점 찾기

        dfs(Ri, Rj, 0);
        System.out.println("Red Count : " + countBlue);

        countBlue = Integer.MAX_VALUE;
        dfs(Bi, Bj, 0);
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

    public static void dfs(int x, int y, int cnt){
        cnt++;
        //go up
        for(int i=x; i>1; i--){
            if(Board[i-1][y] == '#')
                dfs(i, y, cnt);
            if(Board[i][y] == 'O'){
                if(countBlue > cnt)
                    countBlue = cnt;
                return;
            }
        }
        //go down
        for(int i=x; i<N-1; i++){
            if(Board[i+1][y] == '#')
                dfs(i, y, cnt);
            if(Board[i][y] == 'O'){
                if(countBlue > cnt)
                    countBlue = cnt;
                return;
            }
        }
        //go right
        for(int i=y; i<M-1; i++){
            if(Board[x][i+1] == '#')
                dfs(x, i, cnt);
            if(Board[x][i] == 'O'){
                if(countBlue > cnt)
                    countBlue = cnt;
                return;
            }
        }
        //go left
        for(int i=y; i>1; i--){
            if(Board[x][i-1] == '#')
                dfs(x, i, cnt);
            if(Board[x][i] == 'O'){
                if(countBlue > cnt)
                    countBlue = cnt;
                return;
            }
        }
        return;
    }
}