import java.io.*;

public class S2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int N = Integer.parseInt(br.readLine().trim());
        String[] numStr = br.readLine().trim().split(" ");
        int[] numbers = new int[numStr.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numStr[i]);
        }

        int increasingLength = 1;
        int decreasingLength = 1;
        int maxLength = 1;

        for (int i = 1; i < N; i++) {
            if (numbers[i] >= numbers[i-1]) {
                increasingLength++;
            } else {
                increasingLength = 1;
            }

            if (numbers[i] <= numbers[i-1]) {
                decreasingLength++;
            } else {
                decreasingLength = 1;
            }

            maxLength = Math.max(maxLength, Math.max(increasingLength, decreasingLength));
        }

        sb.append(maxLength);
        bw.write(sb.toString());
        bw.close();
    }
}

