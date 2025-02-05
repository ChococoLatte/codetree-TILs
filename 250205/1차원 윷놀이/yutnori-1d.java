import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K,max;
    static int[] turns;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new int[N];
        turns = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            turns[i] = Integer.parseInt(st.nextToken());
        }

        max = 0;
        perm(0);

        System.out.println(max);

    }

    static void perm(int cnt){

        if(cnt == N){
            calcMax();
            return;
        }

        for(int i=1;i<=K;i++){
            num[cnt] = i;
            perm(cnt+1);
        }
    }

    static void calcMax(){
        
        int cnt = 0;

        int[] arr = new int[K+1];
        for(int i=0;i<N;i++){
            arr[num[i]] += turns[i];
        }

        for(int i=1;i<=K;i++){
            if(arr[i]>=M-1){
                cnt++;
            }
        }

        max = Math.max(max,cnt);
    }
}