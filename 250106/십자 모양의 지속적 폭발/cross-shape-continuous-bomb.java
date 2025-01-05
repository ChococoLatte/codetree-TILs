import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            q.add(Integer.parseInt(br.readLine())-1);
        }

        while(!q.isEmpty()){
            int c = q.poll();

            findCol(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void findCol(int c){

        for(int i=0;i<n;i++){
            if(arr[i][c]!=0){
                bomb(i,c);
                break;
            }
        }
    }

    static void bomb(int r, int c){

        int d = arr[r][c];

        arr[r][c] = 0;
        for(int i=0;i<4;i++){
            for(int j=1;j<d;j++){
                int nx = r+dx[i]*j;
                int ny = c+dy[i]*j;

                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                
                arr[nx][ny] = 0;
            }
        }

        gravity();

    }

    static void gravity(){

        for(int i=0;i<n;i++){
            int[] tmpArry = new int[n];
            int idx = n-1;
            for(int j=n-1;j>=0;j--){
                if(arr[j][i]!=0) tmpArry[idx--] = arr[j][i];
            }

            for(int j=n-1;j>=0;j--){
                arr[j][i] = tmpArry[j];
            }
        }
    }
}