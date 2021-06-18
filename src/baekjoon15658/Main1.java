package baekjoon15658;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1 {
    static int N;
    static int[] numArray;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numArray = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<N; i++){
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        int plusCount = 0;
        int minusCount = 0;
        int multiCount = 0;
        int divCount = 0;

        st = new StringTokenizer(br.readLine()," ");
        plusCount = Integer.parseInt(st.nextToken());
        minusCount = Integer.parseInt(st.nextToken());
        multiCount = Integer.parseInt(st.nextToken());
        divCount = Integer.parseInt(st.nextToken());

        pickOperator(1, numArray[0], plusCount,minusCount,multiCount,divCount);
        bw.write(String.valueOf(max)+"\n");
        bw.write(String.valueOf(min));
        bw.flush();

    }
    /*
        index       : 연산 대상이 되는 숫자의 인덱스
        tempResult  : 중간 연산 결과 값
        ** Count    : 선택가능한 연산자의 수

     */
    public static void pickOperator(int index, int tempResult,int plusCount, int minusCount, int multiCount, int divCount ){
        if(index>=numArray.length){
            max = Math.max(tempResult, max);
            min = Math.min(tempResult,min);
        }
        else{
            if(plusCount>0) pickOperator(index+1, tempResult+numArray[index], plusCount-1, minusCount,multiCount, divCount);
            if(minusCount>0) pickOperator(index+1, tempResult-numArray[index], plusCount, minusCount-1,multiCount, divCount);
            if(multiCount>0) pickOperator(index+1, tempResult*numArray[index], plusCount, minusCount,multiCount-1, divCount);
            if(divCount>0) pickOperator(index+1, tempResult/numArray[index], plusCount, minusCount,multiCount, divCount-1);
        }
    }
}
