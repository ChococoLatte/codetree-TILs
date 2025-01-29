import java.io.*;
import java.util.*;

public class Main {
  static int K,N;
  static int[] arr;
  static StringBuilder sb;
	public static void main(String args[]) throws IOException{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st = new StringTokenizer(br.readLine());
	  sb = new StringBuilder();
	  
	  K = Integer.parseInt(st.nextToken());
	  N = Integer.parseInt(st.nextToken());
	  
	  arr = new int[N];
	  perm(0);
	  
	  System.out.println(sb);
	}
	
	static void perm(int cnt){
	  
	  if(cnt == N){
	    for(int i: arr) sb.append(i).append(" ");
	    sb.append("\n");
	    return;
	  }
	  
	  for(int i=0;i<K;i++){
	    arr[cnt] = i+1;
	    perm(cnt+1);
	  }
	}
}