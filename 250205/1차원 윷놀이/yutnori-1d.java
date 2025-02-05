import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K,max;
    static int[] turns;
    static int[] nums;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[K+1];
        turns = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            turns[i] = Integer.parseInt(st.nextToken());
        }

        max = 0;
        dfs(0);

        System.out.println(max);

    }

    static void dfs(int cnt){

        max = Math.max(max,calc());

        if(cnt == N){
            return;
        }

        for(int i=1;i<=K;i++){

            if(nums[i]>=M-1) continue;

            nums[i]+=turns[cnt];
            dfs(cnt+1);
            nums[i]-=turns[cnt];
        }
    }

    static int calc(){

        int cnt = 0;
        for(int i=1;i<=K;i++){
            if(nums[i]>=M-1) cnt++;
        }

        return cnt;
    }
}