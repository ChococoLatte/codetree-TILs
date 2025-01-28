import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxLine = n-1;
        for(int i=k-1;i<k+m-1;i++){
            for(int j=0;j<n;j++){
                if(arr[j][i] == 1){
                    maxLine = Math.min(maxLine,j-1);
                    break;
                }
            }
        }

        for(int j=k-1;j<k+m-1;j++){
            arr[maxLine][j] = 1;    
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}