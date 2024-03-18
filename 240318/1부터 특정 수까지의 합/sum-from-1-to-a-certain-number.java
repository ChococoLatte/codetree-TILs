import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        System.out.println(findRemainder(N));
    }

    static int findRemainder(int N){
        int sum = 0;
        for(int i=1;i<=N;i++){
            sum+=i;
        }

        return sum/10;
    }
}