import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        printLine(N);
        
    }

    static void printLine(int N){
        for(int i=0;i<N;i++){
            System.out.println("12345^&*()_");
        }
    }
}