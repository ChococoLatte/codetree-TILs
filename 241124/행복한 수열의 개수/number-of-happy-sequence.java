import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] seq = new int[n];
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                seq[j] = arr[i][j];
            }
            if(calcSeq(seq)) answer++;
        }

        for(int j=0;j<n;j++){
            for(int i=0;i<n;i++){
                seq[i] = arr[i][j];
            }
            if(calcSeq(seq)) answer++;
        }

        System.out.println(answer);
        
    }

    static boolean calcSeq(int[] seq){

        int cnt = 1;
        int max = 1;

        for(int i=1;i<n;i++){
            if(seq[i-1] == seq[i]){
                cnt++;
            }else{
                cnt = 1;
            }
            max = Math.max(max,cnt);
        }

        return max>=m;
    }
}