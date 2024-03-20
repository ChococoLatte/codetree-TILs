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
            if(isPerfectNumber(i)) cnt++;
        }

        System.out.println(cnt);
    }

    static boolean isPerfectNumber(int num){
        if(num%2 != 0){
            if(num%10 != 5){
                if(num%3 != 0 || num%9==0) return true;
            }
        }
        return false;
    }
}