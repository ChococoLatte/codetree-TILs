import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int l;
        char d;

        public Node(int l, char d){
            this.l = l;
            this.d = d;
        }
    }
    static int N,M,Q;
    static int[][] arr;
    static boolean[] isBlowed;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        isBlowed = new boolean[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken())-1;
            char d = st.nextToken().charAt(0);

            blowWind(l,d);
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void blowWind(int l, char d){

        isBlowed[l] = true;
        
        if(d == 'L'){
            int temp = arr[l][M-1];
            for(int i=M-1;i>0;i--){
                arr[l][i] = arr[l][i-1];
            }
            arr[l][0] = temp;
        }else{
            int temp = arr[l][0];
            for(int i=0;i<M-1;i++){
                arr[l][i] = arr[l][i+1];
            }
            arr[l][M-1] = temp;
        }

        if(l-1>=0 && !isBlowed[l-1]){
            boolean isConcord = false;
            for(int i=0;i<M;i++){
                if(arr[l-1][i] == arr[l][i]){
                    isConcord = true;
                    break;
                }
            }

            if(isConcord){
                blowWind(l-1,reverseDirection(d));
            }
        }

        if(l+1<N && !isBlowed[l+1]){
            boolean isConcord = false;
            for(int i=0;i<M;i++){
                if(arr[l+1][i] == arr[l][i]){
                    isConcord = true;
                    break;
                }
            }

            if(isConcord){
                blowWind(l+1,reverseDirection(d));
            }
        }  
    }

    static char reverseDirection(char d){
        if(d == 'L') return 'R';
        else return 'L';
    }
}