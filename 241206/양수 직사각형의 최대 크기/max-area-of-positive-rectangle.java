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
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=i;k<n;k++){
                    for(int l=j;l<m;l++){
                        visited = new boolean[n][m];
                        max = Math.max(max,calc(i,j,k,l));
                    }
                }
            }
        }
        
        System.out.println(max);
    }

    static int calc(int x,int y,int gx,int gy){
        
        int cnt = 0;
        for(int i=x;i<=gx;i++){
            for(int j=y;j<=gy;j++){
                if(arr[i][j]<0) return -1;
                else cnt++;
            }
        }

        return cnt;
    }

}