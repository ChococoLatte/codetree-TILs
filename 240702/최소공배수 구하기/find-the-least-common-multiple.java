import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        printLCM(n,m);
    }

    static void printLCM(int n, int m){
        int gcd = calcGCD(n,m);
        System.out.println((n/gcd)*(m/gcd)*gcd);
    }

    static int calcGCD(int n, int m){
        int gcd = 1;
        for(int i=Math.min(n,m);i>0;i--){
            if(n%i == 0 && m%i == 0){
                gcd = i;
                break;
            }
        }
        return gcd;
    }
}