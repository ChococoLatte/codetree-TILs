import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        calcGCD(n,m);

    }

    static void calcGCD(int n, int m){
        for(int i=Math.min(n,m);i>=1;i--){
            if(n%i == 0 && m%i==0) { 
                System.out.println(i);
                return;
            }
        }
    }
}