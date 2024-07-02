import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        printRectN(n);
    }

    static void printRectN(int n){
        int num = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(num == 10) num=1;
                System.out.print((num++)%10+" ");
            }
            System.out.println();
        }
    }
}