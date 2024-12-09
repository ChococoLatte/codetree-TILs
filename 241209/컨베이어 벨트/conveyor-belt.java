import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] arr = new int[2][n];
        for(int i=0;i<2;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                if(i==0){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }else{
                    arr[i][n-1-j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i=0;i<t;i++){
            int temp1 = arr[1][0];
            int temp2 = arr[0][n-1];
            for(int j=n-1;j>=1;j--){
                arr[0][j] = arr[0][j-1];
            }

            for(int j=0;j<n-1;j++){
                arr[1][j] = arr[1][j+1];
            }
            arr[0][0] = temp1;
            arr[1][n-1] = temp2;
        }

        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                if(i == 0) System.out.print(arr[i][j]+" ");
                else System.out.print(arr[i][n-1-j]+" ");
            }
            System.out.println();
        }
    }
}