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
    static int n,max;
    static int[][] arr;
    static int[][] dx = {{-2,-1,1,2},{-1,1,0,0},{-1,-1,1,1}};
    static int[][] dy = {{0,0,0,0},{0,0,-1,1},{-1,1,-1,1}};
    static ArrayList<Point> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        list = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    list.add(new Point(i,j));
                }
            }
        }

        max = Integer.MIN_VALUE;
        dfs(0);

        System.out.println(max);
    }

    static void dfs(int cnt){

        if(cnt == list.size()){
            max = Math.max(max,countBomb());
            return;
        }

        Point p = list.get(cnt);
        for(int i=0;i<3;i++){
            bomb(i,p.x,p.y,1);
            dfs(cnt+1);
            bomb(i,p.x,p.y,-1);
        }   
    }

    static void bomb(int num, int x, int y, int val){
       arr[x][y] += val;

       for(int i=0;i<4;i++){
            int nx = x+dx[num][i];
            int ny = y+dy[num][i];

            if(inRange(nx,ny)){
                arr[nx][ny]+=val;
            }
       }
    }

    static boolean inRange(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
    }

    static int countBomb(){
        
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]>0) cnt++;
            }
        }

        return cnt;
    }
}