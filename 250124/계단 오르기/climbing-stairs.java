import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        climbingStairs(N,dp);
        System.out.println(dp[N]);

    }

    static void climbingStairs(int N, int[] dp){

        if(N>=2){
            dp[2] = 1;
        }

        if(N>=3){
            dp[3] = 1;
        }

        for(int i=4;i<=N;i++){
            dp[i] = dp[i-2]+dp[i-3];
        }
    }
}