import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        for(int i=0;i<2;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int firstIdx = Integer.parseInt(st.nextToken())-1;
            int lastIdx = Integer.parseInt(st.nextToken());

            list.subList(firstIdx, lastIdx).clear();
        }

        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
