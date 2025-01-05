import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[4][4];
        for(int i=0;i<4;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        char c = br.readLine().charAt(0);
        if(c == 'R'){
            for(int i=0;i<4;i++){
                for(int j=3;j>=1;j--){
                    if(arr[i][j] == 0){
                        for(int k=j;k>=1;k--){
                            arr[i][k] = arr[i][k-1];
                            arr[i][k-1] = 0;
                        }
                    }

                    if(arr[i][j] == arr[i][j-1]){
                        arr[i][j]+=arr[i][j-1];
                        arr[i][j-1] = 0;
                    }
                }
            }
        }else if(c == 'L'){
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    if(arr[i][j] == 0){
                        for(int k=j;k<3;k++){
                            arr[i][k] = arr[i][k+1];
                            arr[i][k+1] = 0;
                        }
                    }

                    if(arr[i][j] == arr[i][j+1]){
                        arr[i][j]+=arr[i][j+1];
                        arr[i][j+1] = 0;
                    }
                }
            }
        }else if(c=='U'){
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    if(arr[j][i] == 0){
                        for(int k=j;k<3;k++){
                            arr[k][i] = arr[k+1][i];
                            arr[k+1][i] = 0;
                        }
                    }

                    if(arr[j][i] == arr[j][i+1]){
                        arr[j][i]+=arr[j][i+1];
                        arr[j][i+1] = 0;
                    }
                }
            }
        }else{
            for(int i=0;i<4;i++){
                for(int j=3;j>=1;j--){
                    if(arr[j][i] == 0){
                       for(int k=j;k>=1;k--){
                            arr[k][i] = arr[k-1][i];
                            arr[k-1][i] = 0;
                        }
                    }

                    if(arr[j][i] == arr[j][i-1]){
                        arr[j][i]+=arr[j][i-1];
                        arr[j][i-1] = 0;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}