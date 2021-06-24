package baekjoon14499;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int x;
    static int y;
    static int K;
    static int[][] map;
    static int[] dice;
    static int[] dx ={0,0,-1,1};
    static int[] dy = {1,-1,0,0};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dice = new int[6];
        for(int r =0; r<N; r++){
            st = new StringTokenizer(br.readLine()," ");
            for(int c=0; c<M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int k = 0; k<K; k++){
            int command = Integer.parseInt(st.nextToken());

            //주사위 위치 이동
            int nx = x + dx[command-1];
            int ny = y + dy[command-1];
            if(nx<0 || ny<0 || nx>=N || ny>=M){
                continue;
            }

            x = nx;
            y = ny;

            //주사위 굴리기
            int upperSide = execute(command,x, y);
            bw.write(upperSide +"\n");

        }
        bw.flush();

    }

    public static int execute(int command, int x, int y){
        int[] tempDice = new int[6];
        switch (command){
            case 1:
                tempDice[2] = dice[0];
                tempDice[1] = dice[1];
                tempDice[5] = dice[2];
                tempDice[0] = dice[3];
                tempDice[4] = dice[4];
                tempDice[3] = dice[5];
                break;
            case 2:
                tempDice[3] = dice[0];
                tempDice[1] = dice[1];
                tempDice[0] = dice[2];
                tempDice[5] = dice[3];
                tempDice[4] = dice[4];
                tempDice[2] = dice[5];
                break;
            case 3:
                tempDice[4] = dice[0];
                tempDice[0] = dice[1];
                tempDice[2] = dice[2];
                tempDice[3] = dice[3];
                tempDice[5] = dice[4];
                tempDice[1] = dice[5];
                break;
            case 4:
                tempDice[1] = dice[0];
                tempDice[5] = dice[1];
                tempDice[2] = dice[2];
                tempDice[3] = dice[3];
                tempDice[0] = dice[4];
                tempDice[4] = dice[5];
                break;
        }
        dice = tempDice;

        if(map[x][y]==0){
            map[x][y]=dice[5];
        }
        else{
            dice[5]=map[x][y];
            map[x][y] = 0;
        }

        return dice[0];
    }
}
