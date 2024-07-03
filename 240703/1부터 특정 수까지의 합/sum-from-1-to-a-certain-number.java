import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(sumDivTen(n));
    }

    static int sumDivTen(int n){
        int tot = 0;
        for(int i=1;i<=n;i++){
            tot+=i;
        }

        return tot/10;
    }
}