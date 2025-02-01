import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int max;
    static boolean[] isOverlapped;
    static ArrayList<Point> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        list = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Point(x,y));
        }

        isOverlapped = new boolean[1001];
        max = Integer.MIN_VALUE;
        dfs(0,0);

        System.out.println(max);
    
    }

    static void dfs(int cnt, int num) {
        if (cnt == list.size()) {
            max = Math.max(max, num);
            return;
        }

        Point p = list.get(cnt);
        boolean flag = false;

        // 현재 구간이 이미 선택된 구간과 겹치는지 확인
        for (int i = p.x; i <= p.y; i++) {
            if (isOverlapped[i]) {
                flag = true;
                break;
            }
        }

        // 겹치는 경우, 현재 선택을 건너뛰고 max 값 갱신
        if (flag) {
            dfs(cnt + 1, num);
            return;
        }

        // 현재 구간을 선택한 경우
        for (int i = p.x; i <= p.y; i++) {
            isOverlapped[i] = true;
        }

        dfs(cnt + 1, num + 1);

        // 현재 구간만 다시 false로 되돌려야 함
        for (int i = p.x; i <= p.y; i++) {
            isOverlapped[i] = false;
        }
    }
}