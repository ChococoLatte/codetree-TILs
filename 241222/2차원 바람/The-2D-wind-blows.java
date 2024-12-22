import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        while(Q->0){
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken())-1;
            int c1 = Integer.parseInt(st.nextToken())-1;
            int r2 = Integer.parseInt(st.nextToken())-1;
            int c2 = Integer.parseInt(st.nextToken())-1;

            rotate(r1,c1,r2,c2);
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void rotate(int r1, int c1, int r2, int c2){

        int[][] tempArr = new int[N][M];
        copyArr(tempArr);

        for(int i=c2;i>c1;i--){
            arr[r1][i] = tempArr[r1][i-1];
        }

        for(int i=r2;i>r1;i--){
            arr[i][c2] = tempArr[i-1][c2];
        }

        for(int i=c1;i<c2;i++){
            arr[r2][i] = tempArr[r2][i+1];
        }

        for(int i=r1;i<r2;i++){
            arr[i][c1] = tempArr[i+1][c1];
        }

        copyArr(tempArr);
        for(int i=r1;i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                int sum = 0;
                int cnt = 0;
                for(int k=0;k<4;k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                    sum+=tempArr[nx][ny];
                    cnt++;
                }
                if(cnt!=0) arr[i][j] = sum/cnt;
            }
        }
    }

    static void copyArr(int tempArr){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                tempArr[i][j] = arr[i][j];
            }
        }
    }
}