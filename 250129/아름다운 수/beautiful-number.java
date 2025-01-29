import java.io.*;
import java.util.*;

public class Main {
    static int n,totCnt;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        perm(0);

        System.out.println(totCnt);
    }

    static void perm(int cnt){

        if(cnt == n){
            if(isBeautiful()){
                totCnt++;
            }
            return;
        }

        for(int i=0;i<4;i++){
            list.add(i+1);
            perm(cnt+1);
            list.remove(list.size()-1);
        }
    }

    static boolean isBeautiful(){

        for(int i=0;i<n;i+=list.get(i)){
            if(i+list.get(i)>n){
                return false;
            }

            for(int j=i;j<i+list.get(i);j++){
                if(list.get(j)!=list.get(i)){
                    return false;
                }
            }
        }
        return true;
    }
}