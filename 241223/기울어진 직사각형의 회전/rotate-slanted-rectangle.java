import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dx = {-1,-1,1,1};
    static int[] dy = {1,-1,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int m3 = Integer.parseInt(st.nextToken());
        int m4 = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        int[] mList = {m1,m2,m3,m4};
        rotate(r,c,mList,dir);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rotate(int r, int c, int[] mList, int dir){

        int r1 = r;
        int c1 = c;

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<4;i++){
            for(int j=0;j<mList[i];j++){
                r1+=dx[i];
                c1+=dy[i];

                list.add(arr[r1][c1]);
            }
        }

        if(dir == 1){
            int val = list.pollFirst();
            list.addLast(val);
        }else if(dir == 0){
            int val = list.pollLast();
            list.addFirst(val);
        }

        for(int i=0;i<4;i++){
            for(int j=0;j<mList[i];j++){
                r+=dx[i];
                c+=dy[i];

                arr[r][c] = list.pollFirst();
            }
        }
    }
}
