package baekjoon11653;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
/*
    moonjuKwak
    2부터 N까지 에라토스테네스의 체를 이용해 소수를 구한다.
    N을 2부터 N까지의 소수를 차례로 나눈다.
    이때 N을 소수로 나눴을 때의 나머지가 0이면 해당소수를 소인수에 추가하고 N을 N/소수로 업데이트 한다 .

 */
public class Main {
    static int N;
    static boolean[] noPrime;
    static List<Integer> primeFactors;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        noPrime = new boolean[N+1];
        primeFactors = new ArrayList<>();

        if(N !=1){
            checkPrime();
            getPrimeFactor();

            for(int num : primeFactors){
                bw.write(String.valueOf(num)+"\n");
            }
        }

        bw.flush();


    }

    public static void checkPrime(){
        for(int num = 2; num<=N ; num++){
            if(!noPrime[num]){
                for(int mul = 2; mul*num<=N; mul++){
                    noPrime[num*mul] = true;
                }
            }
        }
    }

    public static void getPrimeFactor(){
        int temp = N;
        for(int index = 2; index<=N; index++){
            if(!noPrime[index]){
                while(temp % index ==0 && temp!=1){
                    temp = temp/index;
                    primeFactors.add(index);

                }
            }
        }
    }


}
