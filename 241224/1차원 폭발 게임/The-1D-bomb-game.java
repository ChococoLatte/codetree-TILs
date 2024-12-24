import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        // 폭탄이 더 이상 터지지 않을 때까지 반복
        while (true) {
            if (!explode(list)) {
                break;
            }
        }

        // 결과 출력
        System.out.println(list.size());
        for (int bomb : list) {
            System.out.println(bomb);
        }
    }

    static boolean explode(LinkedList<Integer> list) {
        int cnt = 1; // 연속된 숫자의 개수
        int startIdx = 0; // 연속된 숫자 구간의 시작 인덱스
        boolean exploded = false;

        for (int i = 1; i <= list.size(); i++) {
            if (i < list.size() && list.get(i).equals(list.get(i - 1))) {
                cnt++;
            } else {
                // 연속된 숫자가 M개 이상인 경우 폭발
                if (cnt >= M) {
                    for (int j = 0; j < M; j++) {
                        list.remove(startIdx);
                    }
                    exploded = true;
                    break; // 한 번 터지면 리스트를 다시 탐색
                }
                // 연속 구간 초기화
                cnt = 1;
                startIdx = i;
            }
        }
        return exploded;
    }
}
