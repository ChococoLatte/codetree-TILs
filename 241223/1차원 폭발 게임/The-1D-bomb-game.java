import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static boolean hasEqual;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        while(true) {
            if(!explode(list)) {
                break;
            }
        }

        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static boolean explode(LinkedList<Integer> list){

        int cnt = 1;
        int idx = 0;
        for(int i=1;i<list.size();i++){
            if (list.get(i).equals(list.get(i-1))) {
                cnt++;
                if(cnt >= M && (i == list.size() - 1 || !list.get(i).equals(list.get(i + 1)))){
                    for(int j=0;j<M;j++){
                        list.remove(idx);
                    }
                    return true;
                }
            }else{
                cnt = 1;
                idx = i;
            }
        }
        return false;
    }
}
