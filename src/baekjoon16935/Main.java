package baekjoon16935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;
/*
6 8 1
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
2
 */
public class Main {
    static int N, M, R;
    static int[][] array;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        for(int n = 0; n<N; n++){
            st = new StringTokenizer(br.readLine()," ");
            for(int m = 0; m<M; m++){
                array[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int r =0; r<R ; r++){
            int command = Integer.parseInt(st.nextToken());
            switch (command){
                case 1:
                    operation1();
                    break;
                case 2:
                    operation2();
                    break;
                case 3:
                    operation3();
                    break;
                case 4:
                    operation4();
                    break;
                case 5:
                    operation5();
                    break;
                case 6:
                    operation6();
                    break;
            }
        }

        printArray(array);
    }

    public static void operation1(){
        //상하반전
        // 크기가 N인 0~ N-1 번째 행에 대해서, K번째 행과 N-K-1번째 행의 위치를 바꾼다
        N = array.length;
        M = array[0].length;
        int[][] temp = new int[N][M];
        for(int r = 0; r<N; r++){
            for(int c=0; c<M ; c++){
                temp[N-r-1][c] = array[r][c];
            }
        }

        array = temp;

    }
    public static void operation2(){
        //좌우반전
        // 크기가 N인 0~ M-1 번째 열에 대해서, K번째 열과 M-K-1번째 열의 위치를 바꾼다
        N = array.length;
        M = array[0].length;
        int[][] temp = new int[N][M];
        for(int c = 0; c<M; c++){
            for(int r=0;r<N ; r++){
                temp[r][M-c-1] = array[r][c];
            }
        }

        array = temp;

    }

    public static void operation3(){
        N = array.length;
        M = array[0].length;
        int[][] temp = new int[M][N];
        for(int r =0; r<array.length; r++){
            for(int c=0; c<array[0].length; c++){
                temp[c][array.length-1-r] = array[r][c];
            }
        }

        array = temp;
    }
    public static void operation4(){
        N = array.length;
        M = array[0].length;
        int[][] temp = new int[M][N];
        for(int r =0; r<array.length; r++){
            for(int c=0; c<array[0].length; c++){
                temp[array[0].length-1-c][r] = array[r][c];
            }
        }

        array = temp;

    }
    public static void operation5(){
        //1->2
        N = array.length;
        M = array[0].length;
        int[][] temp = new int[N][M];
        for(int r =0; r<N/2; r++){
            for(int c =0; c<M/2; c++){
                temp[r][c+M/2]=array[r][c];
            }
        }

        //2->3
        for(int r =0; r<N/2; r++){
            for(int c = M/2; c<M; c++){
                temp[r+N/2][c] = array[r][c];
            }
        }

        //3->4
        for(int r =N/2; r<N; r++){
            for(int c = M/2; c<M; c++){
                temp[r][c-M/2] = array[r][c];
            }
        }

        //4->1
        for(int r =N/2; r<N; r++){
            for(int c = 0; c<M/2; c++){
                temp[r-N/2][c] = array[r][c];
            }
        }

        array = temp;
    }

    public static void operation6(){
        //1->4
        N = array.length;
        M = array[0].length;
        int[][] temp = new int[N][M];
        for(int r =0; r<N/2; r++){
            for(int c =0; c<M/2; c++){
                temp[r+N/2][c]=array[r][c];
            }
        }

        //2->1
        for(int r =0; r<N/2; r++){
            for(int c = M/2; c<M; c++){
                temp[r][c-M/2] = array[r][c];
            }
        }

        //3->2
        for(int r =N/2; r<N; r++){
            for(int c = M/2; c<M; c++){
                temp[r-N/2][c] = array[r][c];
            }
        }

        //4->3
        for(int r =N/2; r<N; r++){
            for(int c = 0; c<M/2; c++){
                temp[r][c+M/2] = array[r][c];
            }
        }

        array = temp;
    }

    public static void printArray(int[][] array){
        for(int r = 0; r<array.length; r++){
            for(int c=0; c<array[r].length; c++){
                System.out.print(array[r][c]+" ");
            }
            System.out.println();
        }
    }
}
