package baekjoon16926;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[][] before;
    static int[][] after;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int N;
    static int M;
    static int R;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        before = new int[N][M];
        after = new int[N][M];


        for(int r = 0; r<N; r++){
            st = new StringTokenizer(br.readLine()," ");
            for(int c=0; c<M; c++){
                before[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r= 0; r<R; r++){
            rotate();
            copyMap();
        }

        for(int r =0; r<N; r++){
            for(int c=0; c<M; c++){
                bw.write(String.valueOf(after[r][c])+" ");
            }
            bw.write("\n");
        }

        bw.flush();
    }

    public static void rotate(){
        visited = new boolean[N][M];
        for(int r=0; r<Math.min(M,N)/2; r++){
            int x = r;
            int y = r;
            int nx =-1;
            int ny = -1;
            int d =0;

            while(!(nx==r && ny==r)){
                nx = x + dx[d];
                ny = y + dy[d];

                if(!valid(nx,ny)){
                    d = (d+1)%4;
                    nx = x + dx[d];
                    ny = y + dy[d];

                }

                after[nx][ny] = before[x][y];

                visited[nx][ny] = true;
                x = nx;
                y = ny;


            }
        }
    }

    public static boolean valid(int x, int y){
        if(x<0 || y<0 || x>=N || y>=M){
            return false;
        }
        if(visited[x][y]){
            return false;
        }
        return true;
    }

    public static void copyMap(){
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                before[r][c] = after[r][c];
            }
        }
    }

}
