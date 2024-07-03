import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int a = Integer.parseInt(st.nextToken());
       int b = Integer.parseInt(st.nextToken());

       int tot = 0;
       for(int i=a;i<=b;i++){
          if(isPrime(i)) tot+=i;
       }

       System.out.println(tot);
    }

    static boolean isPrime(int n){
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i==0) return false;
        }

        return true;
    }
}