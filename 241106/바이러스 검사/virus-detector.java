import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long tl = Long.parseLong(st.nextToken());
        long tm = Long.parseLong(st.nextToken());

        long cnt = 0;
        for(int i=0;i<n;i++){
            arr[i]-=tl;
            cnt++;
            if(arr[i]>0){
                cnt+=(arr[i]/tm);
                if(arr[i]%tm != 0) cnt++;
            }
        }

        System.out.println(cnt);
    }
}