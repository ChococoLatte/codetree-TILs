import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i=a;i<=b;i++){
            if(isPrime(i) && isEven(i)) cnt++;
        }

        System.out.println(cnt);
    }

    static boolean isPrime(int num){

        if(num == 1) return false;
        if(num == 2) return true;

        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i == 0) return false;
        }

        return true;
    }

    static boolean isEven(int num){
        String strNum = String.valueOf(num);

        int sum = 0;
        while(num!=0){
            sum+=(num%10);
            num/=10;
        }

        if(sum%2 == 0) return true;
        else return false;
    }
}