package baekjoon14890;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int L;
    static int[][] map;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine()," ");
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int pathCount = 0;
        //가로
        for(int r= 0; r<N; r++){
            if(canMakePath(r, 0, 0)) ++pathCount;
        }
        //세로
        for(int c=0; c<N; c++){
            if(canMakePath(0, c, 1)) ++pathCount;
        }

        bw.write(pathCount);
        bw.flush();

    }
    public static boolean canMakePath(int x, int y, int d){
        int currentX = x;
        int currentY = y;
        int beforeX = currentX - dx[d];
        int beforeY = currentY - dy[d];
        int sameHeightCount = 1;

        while(true){
            //현재위치 이동
            currentX = currentX+dx[d];
            currentY = currentY+dy[d];

            beforeX = beforeX +dx[d];
            beforeY = beforeY + dy[d];

            if(currentX>=N || currentY>N){
                break;
            }

            //현재위치와 이전위치의 높이 비교
            if(map[beforeX][beforeY]< map[currentX][currentY]){
                    if(map[currentX][currentY]-map[beforeX][beforeY] ==1 && sameHeightCount>=L){
                        sameHeightCount =1;
                    }
                    else{
                        return false;
                    }
            }
            else if(map[beforeX][beforeY] == map[currentX][currentY]){
                sameHeightCount += 1;
            }
            else{
                if(map[beforeX][beforeY] - map[currentX][currentY]==1){
                    //현재위치 기준 같은 높이의 칸의 갯수 구하기
                    int count = getNumberOfSameHeight(currentX, currentY,d);
                    if(count>=L){

                        //현재위치 이동
                        for(int c = 0; c<count-1; c++){
                            currentX = currentX+dx[d];
                            currentY = currentY+dy[d];
                        }

                        beforeX = currentX;
                        beforeY = currentY;
                        sameHeightCount = 1;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public static int getNumberOfSameHeight(int baseX, int baseY, int direction){
        int count = 1;
        int baseHeight = map[baseX][baseY];

        int nx = baseX;
        int ny = baseY;
        while(true){
            nx = nx+dx[direction];
            ny = ny+dy[direction];

            if(nx<0 || ny<0 || nx>=N ||ny>=N){
                break;
            }

            if(map[nx][ny] == baseHeight){
                ++count;
            }
            else{
                break;
            }
        }


        return count;
    }
}
