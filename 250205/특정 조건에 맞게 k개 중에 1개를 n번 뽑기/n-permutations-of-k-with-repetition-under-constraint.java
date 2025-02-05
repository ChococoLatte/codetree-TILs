import java.io.*;
import java.util.*;

public class Main {
    static int K,N;
    static int[] num;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        num = new int[N];
        sb = new StringBuilder();
        perm(0);

        System.out.println(sb);
    }

    static void perm(int cnt){

        if(cnt == N){
            if(!isThreeContinuous()){
                for(int nm:num){
                    sb.append(nm).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=0;i<K;i++){
            num[cnt] = i+1;
            perm(cnt+1); 
        }
    }

    static boolean isThreeContinuous(){
        
        int prev = num[0];
        int cnt = 1;
        for(int i=1;i<N;i++){
            if(prev == num[i]){
                cnt++;
            }else{
                prev = num[i];
                cnt = 1;
            }

            if(cnt>=3) return true;
        }

        return false;
    }
}