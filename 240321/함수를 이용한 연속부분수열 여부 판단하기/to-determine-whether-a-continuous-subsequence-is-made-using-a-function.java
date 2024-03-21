import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int[] n1Arr = new int[n1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n1;i++){
            n1Arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] n2Arr = new int[n2];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n2;i++){
            n2Arr[i] = Integer.parseInt(st.nextToken());
        }

        if(isConSecutiveNumberSub(n1Arr, n2Arr)) System.out.println("Yes");
        else System.out.println("No");

    }

    static boolean isConSecutiveNumberSub(int[] n1Arr, int[] n2Arr){

        for(int i=0;i<n1Arr.length;i++){
            boolean findDiff = false;
            if(n1Arr[i] == n2Arr[0]){
                for(int j=0;j<n2Arr.length;j++){
                    if(n2Arr[j] != n1Arr[i+j]) findDiff = true;
                }
            }
            if(!findDiff) return true;
        }
        return false;
    }
}