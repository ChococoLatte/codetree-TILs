import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

         int n = Integer.parseInt(br.readLine());
         System.out.println(printAnswer(n));
    }

    static String printAnswer(int n){
        String s = String.valueOf(n);
        int totDigit = 0;
        for(int i=0;i<s.length();i++){
            totDigit+=(s.charAt(i)-'0');
        }

        if(n%2 == 0 && totDigit%5 == 0) return "Yes";
        else return "No";
    }
}