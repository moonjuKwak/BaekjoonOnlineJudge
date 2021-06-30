package baekjoon14503;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Robot{
    int x, y, d, cleanCount;
    public Robot(int x, int y,int d, int cleanCount){
        this.x = x;
        this.y = y;
        this.d= d;
        this.cleanCount = cleanCount;
    }
}
public class Main {
    static int N;
    static int M;
    static int[][] map;
    static final int CLEANED = -1;
    static final int NOT_CLEANED = 0;
    static final int WALL = 1;
    static Robot robot;
    static int[]dx ={-1,0,1,0};
    static int[]dy ={0,1,0,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];


        //로봇 초기화
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        robot = new Robot(x, y, d, 0);

        //지도 초기화
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        cleaningMap();
        bw.write(String.valueOf(robot.cleanCount));
        bw.flush();
    }

    public static void cleaningMap(){
        while(true){
            //현재위치 청소
            map[robot.x][robot.y] = CLEANED;
            robot.cleanCount +=1;

            //왼쪽방향 탐색
            while(true){
                boolean cleaned = false;
                int baseDirection = robot.d;
                for(int count = 0; count<4; count++){
                    int nd = baseDirection -1<0? 3 : baseDirection-1;
                    int nx = robot.x + dx[nd];
                    int ny = robot.y +dy[nd];

                    if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny]==NOT_CLEANED) {
                        robot.d = nd;
                        robot.x = nx;
                        robot.y = ny;
                        cleaned = true;
                        break;
                    }

                    baseDirection = nd;
                }


                if(cleaned){
                    break;
                }
                else{
                    //뒤로 후진 가능 한지
                    int nd = (robot.d%4 -2%4 +4)%4;
                    int nx = robot.x +dx[nd];
                    int ny = robot.y +dy[nd];

                    if(nx<0 || ny<0 || nx>=N | ny>=M || map[nx][ny] == WALL){
                        return;
                    }
                    else{
                        robot.x = nx;
                        robot.y = ny;
                    }
                }
            }
        }
    }
}
