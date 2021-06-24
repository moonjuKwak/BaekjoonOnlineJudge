package baekjoon16926;

public class Case {
    public static void main(String[] args) {
        int num = 1;
        for(int r=0; r<300; r++){
            for(int c=0; c<300; c++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }
}
