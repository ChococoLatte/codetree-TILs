import java.io.*;
import java.util.*;

public class Main {
    static int n,maxCnt;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxCnt = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                bomb(i,j);
            }
        }

        System.out.println(maxCnt);
    }

    static void bomb(int r, int c){

        int d = arr[r][c];

        int[][] tmpArr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                tmpArr[i][j] = arr[i][j];
            }
        }

        tmpArr[r][c] = 0;
        for(int i=0;i<4;i++){
            for(int j=1;j<d;j++){
                int nx = r+dx[i]*j;
                int ny = c+dy[i]*j;

                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                tmpArr[nx][ny] = 0;
            }
        }

        gravity(tmpArr);
    }

    static void gravity(int[][] tmpArr){

        for(int i=0;i<n;i++){
            int[] tmpCol = new int[n];
            int idx = n-1;
            for(int j=n-1;j>=0;j--){
                if(tmpArr[j][i]!=0) tmpCol[idx--] = tmpArr[j][i];
            }

            for(int j=n-1;j>=0;j--){
                tmpArr[j][i] = tmpCol[j];
            }
        }

        cntPair(tmpArr);
    }

    static void cntPair(int[][] tmpArr){
        
        int cnt = 0;

        boolean[][] visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(tmpArr[i][j] != 0 && !visited[i][j]){
                    for(int d=0;d<4;d++){
                        int nx = i+dx[d];
                        int ny = j+dy[d];

                        if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                        if(visited[nx][ny]) continue;

                        if(tmpArr[i][j] == tmpArr[nx][ny]){
                            cnt++;
                        }
                    }
                    visited[i][j] = true;
                }
            }
        }

        maxCnt = Math.max(maxCnt,cnt);
    }
}