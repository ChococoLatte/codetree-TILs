import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dropBlock();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dropBlock() {
        
        for (int i = n - 1; i >= 0; i--) {
            boolean canDrop = true;
            for (int j = k - 1; j < k + m - 1; j++) {
                if (arr[i][j] != 0) {
                    canDrop = false;
                    break;
                }
            }

            if (canDrop) {

                for (int j = k - 1; j < k + m - 1; j++) {
                    arr[i][j] = 1;
                }
                
                // 중력 적용 여부 판단
                if (canGravityApply(i, k - 1, k + m - 2)) {
                    applyGravity();
                }
                break;
            }
        }
    }

    static boolean canGravityApply(int row, int startCol, int endCol) {
       
        for (int j = startCol; j <= endCol; j++) {
            if (row == n - 1 || arr[row + 1][j] != 0) {
                return false; 
            }
        }
        return true;
    }

    static void applyGravity() {

        for (int j = 0; j < n; j++) {
            int idx = n - 1; 
            
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i][j] != 0) {
                    arr[idx--][j] = arr[i][j];  
                }
            }
            
            while (idx >= 0) {
                arr[idx--][j] = 0;
            }
        }
    }
}
