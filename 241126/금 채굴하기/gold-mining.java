import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int x;
        int y;
        int k;

        public Node(int x, int y, int k){
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
    static int goldCnt;
    static int n,m,max;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
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
                if(arr[i][j] == 1) goldCnt++;
            }
        }

        max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                bfs(i,j);
            }
        }
        
        System.out.println(max);

    }

    static void bfs(int x, int y){
        int gold = 0;
        
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        q.add(new Node(x,y,0));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(arr[now.x][now.y] == 1) gold++;

            if(m*gold>=(now.k*now.k+(now.k+1)*(now.k+1))){
                max = Math.max(max, gold);
            }

            if(gold == goldCnt){
                return;
            }

            for(int i=0;i<4;i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new Node(nx,ny,now.k+1));
            }
        }
    }
}