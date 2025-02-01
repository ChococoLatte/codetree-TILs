import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Point> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q = new LinkedList<>();
        visited = new boolean[n][m];

        if(bfs(0,0)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    static boolean bfs(int x, int y){

        visited[x][y] = true;
        q.add(new Point(x,y));

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x == n-1 && p.y == m-1){
                return true;
            }

            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(visited[nx][ny] || arr[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.add(new Point(nx,ny));
            }
        }

        return false;
    }
}