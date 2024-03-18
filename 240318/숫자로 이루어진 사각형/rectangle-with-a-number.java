import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        printRect(N);
    }

    static void printRect(int N){
        int num = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(++num%10 == 0? num = 1: num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}