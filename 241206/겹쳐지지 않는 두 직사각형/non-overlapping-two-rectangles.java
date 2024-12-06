import java.io.*;
import java.util.*;

public class Main {
    static int n,m,max;
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

        firstRect();
        System.out.println(max);

    }

    static void firstRect(){
        max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=i;k<n;k++){
                    for(int l=j;l<m;l++){
                        max = Math.max(max,secondRect(i,j,k,l));
                    }
                }
            }
        }
    }

    static int secondRect(int fi,int fj,int fk,int fl){
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=i;k<n;k++){
                    for(int l=j;l<m;l++){
                        if(!isOverride(fi,fj,fk,fl,i,j,k,l)){
                            max = Math.max(max,calcRect(fi,fj,fk,fl,i,j,k,l));
                        }
                    }
                }
            }
        }

        return max;
    }

    static boolean isOverride(int fi, int fj, int fk, int fl, int si, int sj, int sk, int sl){
        boolean visited[][] = new boolean[n][m];
        for(int i=fi;i<=fk;i++){
            for(int j=fj;j<=fl;j++){
                visited[i][j] = true;
            }
        }

        for(int i=si;i<=sk;i++){
            for(int j=sj;j<=sl;j++){
                if(visited[i][j]) return true;
            }
        }

        return false;
    }


    static int calcRect(int fi, int fj, int fk, int fl, int si, int sj, int sk, int sl){
        int tot = 0;
        for(int i=fi;i<=fk;i++){
            for(int j=fj;j<=fl;j++){
                tot+=arr[i][j];
            }
        }

        for(int i=si;i<=sk;i++){
            for(int j=sj;j<=sl;j++){
                tot+=arr[i][j];
            }
        }

        return tot;
    }
}