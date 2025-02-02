import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static int[] num;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        num = new int[N];
        perm(0);

        System.out.println(sb);
    }

    static void perm(int cnt){

        if(cnt == N){
            if(!includeThreeOrMore()){
                for(int i=0;i<N;i++){
                    sb.append(num[i]).append(" ");
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

    static boolean includeThreeOrMore(){

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int nm:num){
            hm.put(nm,hm.getOrDefault(nm,0)+1);
            if(hm.get(nm)>=3) return true;
        }

        return false;
    }
}