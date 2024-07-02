import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        printGCD(n,m);
    }

    static void printGCD(int n, int m){
        for(int i=n;i>0;i--){
            if(n%i==0 && m%i==0){
                System.out.println(i);
                return;
            }
        }
    }
}