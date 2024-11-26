import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int N,max;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,-1,1,1};
    static int[] dy = {1,-1,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        N = Integer.parseInt(br.readLine());
             
        map = new int[N][N];
        visited = new boolean[N][N];
             
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                visited[i][j]=true;
                dfs(i,j,i,j,1,0, map[i][j]);
                visited[i][j]=false;
            }
        }
        System.out.println(max);
    }
     
    private static void dfs(int startX, int startY, int x, int y, int cnt, int dir, int tot) {
         
        for(int i=dir;i<4;i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
             
            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
             
            if(nx==startX && ny==startY && cnt>2) {
                max = Math.max(max,tot);
                return;
            }
             
            if(visited[nx][ny]) continue;
             
            visited[nx][ny]=true;
            dfs(startX,startY,nx,ny,cnt+1,i,tot+map[nx][ny]);
            visited[nx][ny]=false;
        }
    }
}