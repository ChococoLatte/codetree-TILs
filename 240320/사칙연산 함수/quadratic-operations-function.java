import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        String b = st.nextToken();
        int c = Integer.parseInt(st.nextToken());

        System.out.println(calcBasicOperations(a,b,c));
    }

    static String calcBasicOperations(int a, String b, int c){
        String ans = String.valueOf(a)+" "+b+" "+String.valueOf(c)+" = ";
        switch(b){
            case "+":
                ans +=  String.valueOf(a+c);
                break;
            case "-":
                ans +=  String.valueOf(a-c);
                break;
            case "*":
                ans +=  String.valueOf(a*c);
                break;
            case "/":
                ans +=  String.valueOf(a/c);
                break;
            default:
                ans =  "False";
        }
        return ans;
    }
}