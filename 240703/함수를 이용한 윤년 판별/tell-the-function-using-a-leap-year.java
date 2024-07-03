import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int y = Integer.parseInt(br.readLine());
        System.out.println(isLeapYear(y));
    }

    static boolean isLeapYear(int y){
        if(y%4 == 0) {
            if(y%100 == 0 && y%400!=0) return false;
            else return true;
        }else return false;
    }
}