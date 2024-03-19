import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for(int i=a;i<=b;i++){
            countNum(i);
        }
        System.out.println(cnt);
    }

    static void countNum(int num){

        String strNum = String.valueOf(num);
        if(num%3 == 0) cnt++;
        else{
            if(strNum.contains("3") || strNum.contains("6") || strNum.contains("9")) cnt++;
        }
    }
}