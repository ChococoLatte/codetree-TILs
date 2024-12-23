import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int min = s.length();
        for(int i = 0; i < s.length(); i++){
            s = rotate(s);

            char fValue = s.charAt(0);
            int cnt = 1;

            String answer = "";
            for(int j=1;j<s.length();j++){
                if(fValue == s.charAt(j)){
                    cnt++;
                }else if(fValue != s.charAt(j)){
                    answer+=(fValue+Integer.toString(cnt));
                    fValue = s.charAt(j);
                    cnt = 1;
                }

                if(j == s.length()-1){
                    answer+=(fValue+Integer.toString(cnt));
                }
            }
            min = Math.min(min,answer.length());
        }
        System.out.println(min);
    }

    static String rotate(String s){

        LinkedList<Character> list = new LinkedList<>();
        for(char c: s.toCharArray()){
            list.add(c);
        }

        list.addFirst(list.pollLast());
        StringBuilder sb = new StringBuilder();
        for(char c: list){
            sb.append(c);
        }

        return sb.toString();
    }
}
