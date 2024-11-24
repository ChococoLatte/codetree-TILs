import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        checkCol();
        checkRow();

        System.out.println(answer);
    }

    static void checkCol(){

        for(int i=0;i<n;i++){
            int prevNum = arr[i][0];
            int cnt = 1;
            for(int j=1;j<n;j++){
                if(prevNum == arr[i][j]){
                    cnt++;
                    if(cnt == m){
                        answer++;
                        break;
                    }
                }else{
                    prevNum = arr[i][j];
                    cnt = 1;
                }
            }
        }
    }

    static void checkRow(){

        for(int i=0;i<n;i++){
            int prevNum = arr[0][i];
            int cnt = 1;
            for(int j=1;j<n;j++){
                if(prevNum == arr[j][i]){
                    cnt++;
                    if(cnt == m){
                        answer++;
                        break;
                    }
                }else{
                    prevNum = arr[j][i];
                    cnt = 1;
                }
            }
        }
    }
}