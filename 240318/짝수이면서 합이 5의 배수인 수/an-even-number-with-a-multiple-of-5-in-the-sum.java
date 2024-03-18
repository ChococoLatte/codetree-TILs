import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(findNumber(n));
    }

    static String findNumber(int n){
        String strN = String.valueOf(n);
        
        int sum = 0;
        for(int i=0;i<strN.length();i++){
            sum+=(strN.charAt(i) - '0');
        }

        if(n%2 == 0 && sum%5 == 0) return "Yes";
        else return "No";
    }
}