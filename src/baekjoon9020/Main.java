package baekjoon9020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

class Pair{
    int pair1, pair2;
    Pair(){}
    Pair(int pair1, int pair2){
        this.pair1 = pair1;
        this.pair2 = pair2;
    }
}
public class Main {
    static int T;
    static int N;
    static boolean[] notPrimeNumber;
    static Pair pair;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //소수 구하기
        notPrimeNumber = new boolean[10_001];
        getPrimeNumber();



        T = Integer.parseInt(br.readLine());
        for(int t =0; t<T ; t++){
            N = Integer.parseInt(br.readLine());
            pair = new Pair(0,0);

            getPartitionNum();
            if(pair.pair1< pair.pair2){
                bw.write(String.valueOf(pair.pair1)+" "+String.valueOf(pair.pair2)+"\n");
            }
            else{
                bw.write(String.valueOf(pair.pair2)+" "+String.valueOf(pair.pair1)+"\n");
            }
        }
        bw.flush();


    }
    public static void getPrimeNumber(){
        notPrimeNumber[0] = true;
        notPrimeNumber[1] = true;

        for(int num = 2; num<=10_000; num++){
            if(!notPrimeNumber[num]){
                for(int mul = 2; num*mul<=10_000; mul++) {
                    notPrimeNumber[num * mul] = true;
                }
            }
        }
    }

    public static void getPartitionNum(){
        for(int num = 2; num<N; num++){
            if(!notPrimeNumber[num] && !notPrimeNumber[N-num]){
                if(pair.pair1!=0){
                    if(Math.abs(pair.pair1- pair.pair2)> Math.abs(N-2*num)){
                        pair.pair1 = num;
                        pair.pair2 = N-num;
                    }
                }
                else{
                    pair.pair1 = num;
                    pair.pair2 = N-num;
                }


            }
        }
    }

}
