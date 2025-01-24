import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        climbingStairs(N,dp);
        System.out.println(dp[N]);

    }

    static void climbingStairs(int N, int[] dp){

        dp[2] = 1;
        dp[3] = 1;

        for(int i=4;i<=N;i++){
            dp[i] = (dp[i-2]%100007+dp[i-3]%100007)%100007;
        }
    }
}