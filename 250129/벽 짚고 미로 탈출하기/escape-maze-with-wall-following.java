import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;

        char[][] arr = new char[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = str.charAt(j);
            }
        }

        int time = 0;
        int direction = 0;
        while (time++ < N * N) {
            int nx = x + dx[direction % 4];
            int ny = y + dy[direction % 4];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                break;
            }

            if (arr[nx][ny] == '#') {
                direction++;
                time--;

                if (direction == 4 && time == 0) {
                    time = -1;
                    break;
                }
                continue;
            }

            int rightWallX = nx + dx[(4 + direction - 1) % 4];
            int rightWallY = ny + dy[(4 + direction - 1) % 4];
            if (arr[nx][ny] == '.' && arr[rightWallX][rightWallY] == '#') {
                x = nx;
                y = ny;
                continue;
            }

            if (arr[nx][ny] == '.' && arr[rightWallX][rightWallY] == '.') {
                x = rightWallX;
                y = rightWallY;
                direction = (4 + direction - 1) % 4;
                time++;
                continue;
            }
        }

        if (time >= N * N) {
            time = -1;
        }

        System.out.println(time);
    }
}