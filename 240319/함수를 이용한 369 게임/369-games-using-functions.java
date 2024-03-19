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
            if(countNum(i)) cnt++;
        }
        System.out.println(cnt);
    }

    static boolean countNum(int num){

        String strNum = String.valueOf(num);
        if(num%3 == 0) return true;
        else{
            if(strNum.contains("3") || strNum.contains("6") || strNum.contains("9")) return true;
        }
        return false;
    }
}