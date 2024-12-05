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

        // 첫 번째 직사각형 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    int rect1Max = dfs(i, j, i, j, i, j, 1, arr[i][j]);

                    // 두 번째 직사각형 탐색
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            if (!visited[k][l]) {
                                visited[k][l] = true;
                                int rect2Max = dfs(k, l, k, l, k, l, 1, arr[k][l]);
                                maxSum = Math.max(maxSum, rect1Max + rect2Max);
                                visited[k][l] = false;
                            }
                        }
                    }

                    clearVisited(i, j); // 첫 번째 직사각형 방문 복원
                }
            }
        }

        System.out.println(maxSum);
    }

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
                visited[nx][ny] = false;
            }
        }

        return max;
    }

    static boolean isSquare(int minX, int minY, int maxX, int maxY, int cnt) {
        return ((maxX - minX) + 1) * ((maxY - minY) + 1) == cnt;
    }

    static void clearVisited(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = false;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0], cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (!visited[nx][ny]) continue;

                visited[nx][ny] = false;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}
