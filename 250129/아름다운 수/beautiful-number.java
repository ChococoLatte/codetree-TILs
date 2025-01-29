import java.io.*;

public class Main {
    static int n, totCnt;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n];

        perm(0);
        System.out.println(totCnt);
    }

    static void perm(int cnt) {
        if (cnt == n) {
            StringBuilder str = new StringBuilder();
            for (int nm : num) {
                str.append(nm);
            }
            countString(str.toString());
            return;
        }

        for (int i = 0; i < 4; i++) {
            num[cnt] = i + 1;
            perm(cnt + 1);
        }
    }

    static void countString(String str) {
        int curCnt = 1;
        char curChar = str.charAt(0);
        boolean isContinuous = true;

        for (int i = 1; i < str.length(); i++) {
            if (curChar != str.charAt(i)) {
                int curNum = Character.getNumericValue(curChar);
                if (curCnt % curNum != 0) {
                    isContinuous = false;
                    break;
                }

                curCnt = 1;
                curChar = str.charAt(i);
            } else {
                curCnt++;
            }
        }

        // 마지막 문자 그룹에 대한 확인
        int lastNum = Character.getNumericValue(curChar);
        if (curCnt % lastNum != 0) {
            isContinuous = false;
        }

        if (isContinuous) {
            totCnt++;
        }
    }
}
