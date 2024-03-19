import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int sum = 0;
        for(int i=a;i<=b;i++){
            if(isPrime(i)) sum+=i;
        }

        System.out.println(sum);
    }

    static boolean isPrime(int num){

        if(num == 2) return true;
 
        for(int i=2;i<num;i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}