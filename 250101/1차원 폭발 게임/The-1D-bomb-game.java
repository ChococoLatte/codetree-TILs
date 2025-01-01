import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static boolean isFlag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if(m == 1){
            System.out.println(0);
            return;
        } 

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        while(true){
            isFlag = false;
            if(!list.isEmpty()) removeBomb(list);

            if(!isFlag || list.isEmpty()) break;
        }

        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    static void removeBomb(ArrayList<Integer> list){
        if (list.isEmpty()) return;
 
        int firstIdx = 0;
        int first = list.get(0);
        int cnt = 1;
        
        for(int i=1;i<list.size();i++){
            if(first == list.get(i)){
                cnt++;
                if(cnt>=m){
                    for(int j=0;j<cnt;j++){
                        list.remove(firstIdx);
                    }
                    isFlag = true;
                    break;
                }
            }else{
                firstIdx = i;
                first = list.get(i);
                cnt = 1;
            }

            if(i == list.size()-1){
                if(cnt>=m){
                    for(int j=0;j<cnt;j++){
                        list.remove(firstIdx);
                    }
                    isFlag = true;
                    break;
                }
            }
        }
    }
}