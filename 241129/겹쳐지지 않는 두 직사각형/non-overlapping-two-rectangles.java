import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxSum = Integer.MIN_VALUE;

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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    // 첫 번째 직사각형 찾기
                    List<int[]> firstRect = new ArrayList<>();
                    visited[i][j] = true;
                    int firstSum = dfs(i, j, firstRect, arr[i][j], i, i, j, j);

                    // 두 번째 직사각형 찾기
                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < m; y++) {
                            if (!visited[x][y]) {
                                List<int[]> secondRect = new ArrayList<>();
                                visited[x][y] = true;
                                int secondSum = dfs(x, y, secondRect, arr[x][y], x, x, y, y);
                                maxSum = Math.max(maxSum, firstSum + secondSum);
                                resetVisited(secondRect); // 두 번째 직사각형 방문 기록 복구
                            }
                        }
                    }
                    resetVisited(firstRect); // 첫 번째 직사각형 방문 기록 복구
                }
            }
        }

        System.out.println(maxSum);
    }

    static int dfs(int x, int y, List<int[]> rect, int tot, int minX, int maxX, int minY, int maxY) {
        rect.add(new int[]{x, y});
        int sum = tot;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (visited[nx][ny] || arr[nx][ny] < 0) continue;

            // 갱신된 minX, maxX, minY, maxY 계산
            int newMinX = Math.min(minX, nx);
            int newMaxX = Math.max(maxX, nx);
            int newMinY = Math.min(minY, ny);
            int newMaxY = Math.max(maxY, ny);

            // 사각형 조건 검증 후 DFS 호출
            if (isSquare(newMinX, newMaxX, newMinY, newMaxY, rect.size() + 1)) {
                visited[nx][ny] = true;
                sum = Math.max(sum, dfs(nx, ny, rect, tot + arr[nx][ny], newMinX, newMaxX, newMinY, newMaxY));
                visited[nx][ny] = false;
            }
        }
        return sum;
    }

    static boolean isSquare(int minX, int maxX, int minY, int maxY, int cnt) {
        int area = (maxX - minX + 1) * (maxY - minY + 1);
        return area == cnt;
    }

    static void resetVisited(List<int[]> rect) {
        for (int[] cell : rect) {
            visited[cell[0]][cell[1]] = false;
        }
    }
}
