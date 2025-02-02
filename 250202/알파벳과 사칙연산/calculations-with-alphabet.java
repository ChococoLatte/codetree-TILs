import java.io.*;
import java.util.*;

public class Main {
    static int max;
    static String s;
    static ArrayList<Character> alphabet;
    static HashMap<Character, Integer> hm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        alphabet = new ArrayList<>();
        hm = new HashMap<>();

        s = br.readLine();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*') continue;

            if(!alphabet.contains(s.charAt(i))){
                alphabet.add(s.charAt(i));
            }
            
            if(!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),0);
            }
        }

        max = Integer.MIN_VALUE;
        dfs(0);

        System.out.println(max);

    }

    static void dfs(int cnt){

        if(cnt == alphabet.size()){
            max = Math.max(max,calc());
            return;
        }

        for(int i=1;i<=4;i++){
            setValue(cnt,i);
            dfs(cnt+1);
            setValue(cnt,0);
        }
    }

    static void setValue(int cnt, int value){

        char key = alphabet.get(cnt);
        hm.put(key,value);
    }

    static int calc(){

        int tot = 0;
        char unit = ' ';
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*'){
                unit = s.charAt(i);
            }else{
                int val = hm.get(s.charAt(i));
                switch(unit){
                    case '+':
                        tot+=val;
                        break;
                    case '-':
                        tot-=val;
                        break;
                    case '*':
                        tot*=val;
                        break;
                    default:
                        tot=val;
                        break;
                }
            }
        }

        return tot;
    }
}