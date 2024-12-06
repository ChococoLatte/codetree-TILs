import java.io.*;
import java.util.*;

public class Main {
    static int n,m,max;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j] = true;
                dfs(i,j,1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y,int cnt){

        max = Math.max(max,cnt);

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
            if(visited[nx][ny] || arr[nx][ny]<0) continue;

            visited[nx][ny] = true;
            dfs(nx,ny,cnt+1);
            visited[nx][ny] = false;

        }

    }

}