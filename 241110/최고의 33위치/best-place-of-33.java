import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<=n-3;i++){
            int tot = 0;
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    tot+=arr[i+j][i+k];
                }
            }
            max = Math.max(max,tot);
        }
        System.out.println(max);
    }
}