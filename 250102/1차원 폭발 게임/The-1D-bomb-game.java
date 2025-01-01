import java.io.*;
import java.util.*;

public class Main {
    static int n,m,lastIdx;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i=n-1;i>=0;i--){
            arr[i] = Integer.parseInt(br.readLine());
        }

        lastIdx = n;
        while(true){
            if(lastIdx == 0){
                System.out.println(0);
                return;
            }

            boolean flag = false;
            int val = arr[0];
            int cnt = 1;
            for(int i=1;i<lastIdx;i++){
                if(val == arr[i]){
                    cnt++;
                }else{
                    if(cnt>=m){
                        for(int j=1;j<=cnt;j++){
                            arr[i-j] = 0;
                        }
                        flag = true;
                    }
                    val = arr[i];
                    cnt = 1;
                }
            }

            if(cnt>=m){
                for(int j=1;j<=cnt;j++){
                    arr[lastIdx-j] = 0;
                    flag = true;
                }
            }

            if(!flag) break;
            move();
            
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lastIdx).append("\n");
        for(int i=lastIdx-1;i>=0;i--){
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void move(){
        
        int[] temp = new int[n];
        int idx = 0;
        for(int i=0;i<lastIdx;i++){
            if(arr[i]!=0){
                temp[idx++] = arr[i]; 
            }
        }

        lastIdx = idx;
        arr = temp;
    }
}