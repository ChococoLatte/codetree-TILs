import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int n = s.length();
        int minLength = Integer.MAX_VALUE;

        for (int shift = 0; shift < n; shift++) {
            int encodedLength = 0;
            char prevChar = s.charAt(shift);
            int count = 1;

            for (int i = 1; i < n; i++) {
                char currentChar = s.charAt((shift + i) % n);
                if (currentChar == prevChar) {
                    count++;
                } else {
                    encodedLength += 1 + String.valueOf(count).length(); // 문자 + 숫자 길이
                    prevChar = currentChar;
                    count = 1;
                }
            }
            // 마지막 문자 처리
            encodedLength += 1 + String.valueOf(count).length();

            minLength = Math.min(minLength, encodedLength);
        }

        System.out.println(minLength);
    }
}
