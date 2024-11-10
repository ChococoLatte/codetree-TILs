import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i=0;i<n;i++){
            int num = arr[i][0];
            int tot = 1;
            for(int j=1;j<n;j++){
                if(num == arr[i][j]) tot++;
                else{
                    num = arr[i][j];
                    tot = 1;
                }
            }
            if(tot>=m) answer++;
        }

        for(int i=0;i<n;i++){
            int num = arr[i][0];
            int tot = 1;
            for(int j=1;j<n;j++){
                if(num == arr[i][j]) tot++;
                else{
                    num = arr[i][j];
                    tot = 1;
                }
            }
            if(tot>=m) answer++;
        }

        System.out.println(answer);
    }
}