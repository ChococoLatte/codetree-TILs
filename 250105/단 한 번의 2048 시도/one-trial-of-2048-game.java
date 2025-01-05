import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;

    // 0을 오른쪽으로 밀기
    public static void shiftRight(int[] row) {
        int[] newRow = new int[4];
        int idx = 3;

        // 숫자들을 오른쪽으로 밀기
        for (int i = 3; i >= 0; i--) {
            if (row[i] != 0) {
                newRow[idx--] = row[i];
            }
        }

        // 새로운 배열을 기존 배열에 덮어 씌우기
        for (int i = 0; i < 4; i++) {
            row[i] = newRow[i];
        }
    }

    // 0을 왼쪽으로 밀기
    public static void shiftLeft(int[] row) {
        int[] newRow = new int[4];
        int idx = 0;

        // 숫자들을 왼쪽으로 밀기
        for (int i = 0; i < 4; i++) {
            if (row[i] != 0) {
                newRow[idx++] = row[i];
            }
        }

        // 새로운 배열을 기존 배열에 덮어 씌우기
        for (int i = 0; i < 4; i++) {
            row[i] = newRow[i];
        }
    }

    // 0을 위로 밀기
    public static void shiftUp() {
        for (int i = 0; i < 4; i++) {
            int[] col = new int[4];
            for (int j = 0; j < 4; j++) {
                col[j] = arr[j][i];
            }

            shiftLeft(col);

            for (int j = 0; j < 4; j++) {
                arr[j][i] = col[j];
            }
        }
    }

    // 0을 아래로 밀기
    public static void shiftDown() {
        for (int i = 0; i < 4; i++) {
            int[] col = new int[4];
            for (int j = 0; j < 4; j++) {
                col[j] = arr[j][i];
            }

            shiftRight(col);

            for (int j = 0; j < 4; j++) {
                arr[j][i] = col[j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        char c = br.readLine().charAt(0);
        if (c == 'R') {
            // 숫자 합치기
            for (int i = 0; i < 4; i++) {
                // 오른쪽으로 밀기
                shiftRight(arr[i]);

                // 합치기
                for (int j = 3; j > 0; j--) {
                    if (arr[i][j] == arr[i][j - 1]) {
                        arr[i][j] *= 2;
                        arr[i][j - 1] = 0;
                    }
                }

                // 다시 밀기
                shiftRight(arr[i]);
            }
        } else if (c == 'L') {
            for (int i = 0; i < 4; i++) {
                // 왼쪽으로 밀기
                shiftLeft(arr[i]);

                // 합치기
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] == arr[i][j + 1]) {
                        arr[i][j] *= 2;
                        arr[i][j + 1] = 0;
                    }
                }

                // 다시 밀기
                shiftLeft(arr[i]);
            }
        } else if (c == 'U') {
            for (int i = 0; i < 4; i++) {
                // 위로 밀기
                int[] col = new int[4];
                for (int j = 0; j < 4; j++) {
                    col[j] = arr[j][i];
                }

                shiftLeft(col);

                // 합치기
                for (int j = 0; j < 3; j++) {
                    if (col[j] == col[j + 1]) {
                        col[j] *= 2;
                        col[j + 1] = 0;
                    }
                }

                // 다시 밀기
                shiftLeft(col);

                // 업데이트된 컬럼을 다시 배열에 반영
                for (int j = 0; j < 4; j++) {
                    arr[j][i] = col[j];
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                // 아래로 밀기
                int[] col = new int[4];
                for (int j = 0; j < 4; j++) {
                    col[j] = arr[j][i];
                }

                shiftRight(col);

                // 합치기
                for (int j = 3; j > 0; j--) {
                    if (col[j] == col[j - 1]) {
                        col[j] *= 2;
                        col[j - 1] = 0;
                    }
                }

                // 다시 밀기
                shiftRight(col);

                // 업데이트된 컬럼을 다시 배열에 반영
                for (int j = 0; j < 4; j++) {
                    arr[j][i] = col[j];
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
