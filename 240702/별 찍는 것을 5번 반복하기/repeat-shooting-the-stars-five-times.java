import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        for(int i=0;i<5;i++){
            printTenStar();
        }
    }

    static void printTenStar(){
        for(int i=0;i<10;i++){
            System.out.print('*');
        }
        System.out.println();
    }
}