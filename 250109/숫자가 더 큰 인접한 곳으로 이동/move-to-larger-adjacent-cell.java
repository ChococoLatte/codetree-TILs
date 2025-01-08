import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;

        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[r][c] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(arr[r][c]).append(" ");
        while(true){
            
            boolean isArrive = false;
            for(int i=0;i<4;i++){
                int nx = r+dx[i];
                int ny = c+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(visited[nx][ny]) continue;

                if(arr[nx][ny]>arr[r][c]){
                    visited[nx][ny] = true;
                    r = nx;
                    c = ny;

                    sb.append(arr[nx][ny]).append(" ");
                    isArrive = true;
                    break;
                }
            }

            if(!isArrive) break;
        }

        System.out.println(sb);

    }
}