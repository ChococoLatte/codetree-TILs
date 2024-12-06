import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = -1; // 모든 값이 음수인 경우의 기본값
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        if (isPositiveRectangle(i, j, k, l)) {
                            max = Math.max(max, (k - i + 1) * (l - j + 1));
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    // 주어진 직사각형이 양수 직사각형인지 확인
    static boolean isPositiveRectangle(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (arr[i][j] <= 0) return false; // 음수를 발견하면 즉시 종료
            }
        }
        return true;
    }
}
