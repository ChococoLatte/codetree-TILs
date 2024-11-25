import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[][] arr;
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

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max = Math.max(max,chkMaxVal(i,j));
            }
        }

        System.out.println(max);
    }

    static int chkMaxVal(int x, int y){

        int cnt1 = 0;
        if(x-1>=0 && x-1<n && y+1>=0 && y+1<m){
            cnt1+=(arr[x-1][y]+arr[x][y]+arr[x][y+1]);
        }

        int cnt2 = 0;
        if(y+1>=0 && y+1<m && x+1>=0 && x+1<n){
            cnt2+=(arr[x][y]+arr[x][y+1]+arr[x+1][y]);
        }

        int cnt3 = 0;
        if(y-1>=0 && y-1<m && x+1>=0 && x+1<n){
            cnt3+=(arr[x][y-1]+arr[x][y]+arr[x+1][y]);
        }

        int cnt4 = 0;
        if(y-1>=0 && y-1<m && x-1>=0 && x-1<n){
            cnt4+=(arr[x-1][y]+arr[x][y]+arr[x][y-1]);
        }

        int cnt5 = 0;
        if(y-1>=0 && y-1<m && y+1>=0 && y+1<m){
            cnt5+=(arr[x][y-1]+arr[x][y]+arr[x][y+1]);
        }

        int cnt6 = 0;
        if(x-1>=0 && x-1<n && x+1>=0 && x+1<n){
            cnt6+=(arr[x-1][y]+arr[x][y]+arr[x+1][y]);
        }

        return findMax(cnt1, cnt2, cnt3, cnt4, cnt5, cnt6);
    }

    static public int findMax(int... values){
        
        int max = Integer.MIN_VALUE;
        for(int value:values){
            max = Math.max(max,value);
        }
        
        return max;
    }
}