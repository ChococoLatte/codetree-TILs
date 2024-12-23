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

        String input;
        while((input = br.readLine())!=null && !input.isEmpty()){
            String[] inputArr = input.split(" ");

            int firstIdx = Integer.parseInt(inputArr[0])-1;
            int lastIdx = Integer.parseInt(inputArr[1]);

            list.subList(firstIdx, lastIdx).clear();
        }

        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
