import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        printLCM(n, m);
    }

    static void printLCM(int n, int m){
        for(int i=Math.max(n,m);i<=n*m;i++){
            if(i%n == 0 && i%m == 0){
                System.out.println(i);
                return;
            }
        }
    }
}