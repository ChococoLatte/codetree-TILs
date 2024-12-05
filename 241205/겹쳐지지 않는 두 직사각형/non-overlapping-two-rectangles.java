import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = Integer.MIN_VALUE;

        // 첫 번째 직사각형 선택
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true; // 첫 번째 직사각형 시작점
                int rect1Max = dfs(i, j, i, j, i, j, 1, arr[i][j]);

                // 두 번째 직사각형 선택
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        if (!visited[k][l]) {
                            visited[k][l] = true;
                            int rect2Max = dfs(k, l, k, l, k, l, 1, arr[k][l]);
                            maxSum = Math.max(maxSum, rect1Max + rect2Max);
                            visited[k][l] = false; // 복원
                        }
                    }
                }
                visited[i][j] = false; // 복원
            }
        }

        System.out.println(maxSum);
    }

    // 직사각형 내 최대 합 탐색
    static int dfs(int x, int y, int minX, int minY, int maxX, int maxY, int cnt, int tot) {
        int max = tot;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (visited[nx][ny]) continue;

            int tmpMinX = Math.min(minX, nx);
            int tmpMinY = Math.min(minY, ny);
            int tmpMaxX = Math.max(maxX, nx);
            int tmpMaxY = Math.max(maxY, ny);

            if (isSquare(tmpMinX, tmpMinY, tmpMaxX, tmpMaxY, cnt + 1)) {
                visited[nx][ny] = true;
                max = Math.max(max, dfs(nx, ny, tmpMinX, tmpMinY, tmpMaxX, tmpMaxY, cnt + 1, tot + arr[nx][ny]));
                visited[nx][ny] = false; // 복원
            }
        }

        return max;
    }

    // 직사각형 유효성 검사
    static boolean isSquare(int minX, int minY, int maxX, int maxY, int cnt) {
        return ((maxX - minX) + 1) * ((maxY - minY) + 1) == cnt;
    }
}
