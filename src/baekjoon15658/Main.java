package baekjoon15658;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
  풀이
  같은 숫자를 포함하는 수열에서 n-1개를 뽑은 다음, 중복 수열을 허락하지 않고 나열한다.
  예를 들어 + + - - - * * * / 이 있을 경우 + + - - 를 한번 뽑았으면 이후에 + + - - 를 다시 뽑을 수 없다.
  이를 구현하기 위해 두가지 조건을 붙혀 수를 나열 하였다.
  첫번째 조건은 한번 뽑은 인덱스의 숫자를 뽑을 수 없고, 두번째 조건은 같은위치에 같은 연산자가 올 수 없다는 조건이다.
  첫번째 조건에 대한 구현은 인덱스를 중복하지 않고 수를 나열 하면 되고, 두번째 조건은 백트랙킹을 이용하였다.

 */
public class Main {
    static int N;
    static int[] numArray;
    static int totalOperationCount;
    static List<Integer> operations;
    static int[] operationCandi;
    static boolean[] isPicked;
    static final int PLUS = 0;
    static final int MINUS = 1;
    static final int MUL = 2;
    static final int DIV = 3;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numArray = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<N; i++){
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        operations = new ArrayList<>();
        totalOperationCount = 0;
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<4; i++){
            int count = Integer.parseInt(st.nextToken());
            totalOperationCount += count;
            for(int j = 0 ; j<count; j++){
                operations.add(i);
            }
        }

        operationCandi = new int[N-1];
        isPicked = new boolean[totalOperationCount];
        /*
            operations에서 N-1개를 뽑는다 , 중복없이
            매개변수 ( 현재까지 뽑은 연산자의 갯수)
         */

        getResult(0);

        bw.write(String.valueOf(max)+"\n");
        bw.write(String.valueOf(min));
        bw.flush();



    }
    public static void getResult(int count){
        if(count>=N-1){
            //최댓값, 최솟값구하기
            int result = calculate();
            min = Math.min(result,min);
            max = Math.max(result, max);
        }
        else{
            int beforeOperation = -1;
            for(int i = 0; i<operations.size(); i++){
                if(!isPicked[i] && (operations.get(i)!=beforeOperation)){
                    isPicked[i] = true;
                    beforeOperation = operations.get(i);

                    operationCandi[count] = operations.get(i);
                    getResult(count+1);
                    isPicked[i] = false;
                }

            }
        }
    }

    public static int calculate(){
        // numArray , operationCandi
        int result = numArray[0];
        for(int i = 0; i <operationCandi.length; i++){
            int operator = operationCandi[i];
            switch (operator){
                case 0:
                    result += numArray[i+1];
                    break;
                case 1:
                    result -= numArray[i+1];
                    break;
                case 2:
                    result *= numArray[i+1];
                    break;

                case 3:
                    result /= numArray[i+1];
                    break;
            }

        }
        return result;
    }
}
