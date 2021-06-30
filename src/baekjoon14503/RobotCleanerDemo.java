//package baekjoon14503;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;
//
//
//public class RobotCleanerDemo {
//    static  class Robot{
//        int x, y, d, cleanCount;
//        public Robot(int x, int y,int d, int cleanCount){
//            this.x = x;
//            this.y = y;
//            this.d= d;
//            this.cleanCount = cleanCount;
//        }
//    }
//
//    static int N;
//    static int M;
//    static int[][] map;
//    static final int CLEANED = -1;
//    static final int NOT_CLEANED = 0;
//    static final int WALL = 1;
//    static Robot robot;
//    static int[]dx ={-1,0,1,0};
//    static int[]dy ={0,1,0,-1};
//
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine()," ");
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        map = new int[N][M];
//
//
//        //로봇 초기화
//        st = new StringTokenizer(br.readLine(), " ");
//        int x = Integer.parseInt(st.nextToken());
//        int y = Integer.parseInt(st.nextToken());
//        int d = Integer.parseInt(st.nextToken());
//        robot = new Robot(x,y,d,0);
//
//        //지도 초기화
//        for(int r =0; r<N; r++){
//            st = new StringTokenizer(br.readLine(), " ");
//            for(int c =0; c<M; c++){
//                map[r][c] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//
//
//        cleaningMap();
//        bw.write(String.valueOf(robot.cleanCount));
//        bw.flush();
//    }
//
//    public static void cleaningMap(){
//        boolean isBlocked = false;
//        while(!isBlocked){
//            //로봇 현재위치 청소
//            map[robot.x][robot.y] = CLEANED;
//            robot.cleanCount +=1;
//
//
//            boolean isCleaned = false;  //현재 칸 기준 4방향 중 청소한 곳이 있는지 여부
//            int notCleaningCount = 0;
//
//            while(!isCleaned && !isBlocked){
//                //4방향 칸 중에서 청소를 못한 칸의 갯수
//                //왼쪽방향 탐색
//                for(int count = 0; count<4; count++){
//
//                    int nd = robot.d ==0? 3: robot.d-1;
//                    int nx = robot.x +dx[nd];
//                    int ny = robot.y +dy[nd];
//
//                    if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny]==NOT_CLEANED){
//                        isCleaned = true;
//                        robot.x = nx;
//                        robot.y = ny;
//                        robot.d = nd;
//
//                    }
//                    else{
//                        notCleaningCount+=1;
//                        robot.d = nd;
//                    }
//
//                    //4방향 모두 청소할 수 없는 경우
//                    if(notCleaningCount==4){
//                        //후진가능여부
//                       nd = (robot.d + 2)%4;
//                       nx = robot.x +dx[nd];
//                       ny = robot.y +dy[nd];
//
//                       if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny] == WALL){
//                           isBlocked =true;
//                       }
//                       else{
//                           robot.x = nx;
//                           robot.y = ny;
//                       }
//                    }
//                }
//            }
//        }
//    }
//}
//
