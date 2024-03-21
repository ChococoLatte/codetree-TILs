import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if(isDateExist(M,D)) System.out.println("Yes");
        else System.out.println("No");
    }

    static boolean isDateExist(int M, int D){

        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
        
        if(D>=1 && D<=month[M-1]) return true;
        else return false;
    }
}