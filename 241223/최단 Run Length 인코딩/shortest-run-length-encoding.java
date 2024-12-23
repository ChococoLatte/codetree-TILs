import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int min = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (i != 0) s = rotate(s); // 오른쪽으로 shift

            char fValue = s.charAt(0);
            int cnt = 1;
            int encodedLength = 0;

            for (int j = 1; j < s.length(); j++) {
                if (fValue != s.charAt(j)) {
                    encodedLength += 1 + String.valueOf(cnt).length(); // 문자 + 숫자 길이
                    fValue = s.charAt(j);
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
            // 마지막 문자 처리
            encodedLength += 1 + String.valueOf(cnt).length();

            min = Math.min(min, encodedLength);
        }
        System.out.println(min);
    }

    static String rotate(String s) {
        return s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
    }
}
