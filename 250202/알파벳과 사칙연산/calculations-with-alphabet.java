import java.io.*;
import java.util.*;

public class Main {
    static int max;
    static String s;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = new int[6];
        s = br.readLine();

        max = Integer.MIN_VALUE;
        dfs(0);

        System.out.println(max);
        
    }

    static void dfs(int cnt){

        if(cnt == 6){
            max = Math.max(max,calc());
            return;
        }

        for(int i=1;i<=4;i++){
            num[cnt] = i;
            dfs(cnt+1);
        }
    }

    static int getValue(char c){

        return num[c-'a'];

    }

    static int calc(){
        
        int tot = num[s.charAt(0)-'a'];
        for(int i=2;i<s.length();i+=2){
            switch(s.charAt(i-1)){
                case '+':
                    tot+=getValue(s.charAt(i));
                    break;
                case '-':
                    tot-=getValue(s.charAt(i));
                    break;
                case '*':
                    tot*=getValue(s.charAt(i));
                    break;
            }
        }

        return tot;

    }

}