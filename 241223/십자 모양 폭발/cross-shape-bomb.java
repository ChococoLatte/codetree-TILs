import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;

        int r = arr[x][y];
        arr[x][y] = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            for(int j = 1; j < r; j++) {
                nx+=dx[i];
                ny+=dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                arr[nx][ny] = 0;
            }
        }

        int[][] tempArr = new int[n][n];
        for(int i = 0; i < n; i++) {

            int idx = n-1;
            for(int j=n-1; j>=0; j--) {
                if(arr[j][i]==0) continue;
                tempArr[idx][i] = arr[j][i];
                idx--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(tempArr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
