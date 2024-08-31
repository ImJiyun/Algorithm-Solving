import java.io.*;

public class S2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        String[] firstLine = br.readLine().trim().split(" ");
        int T = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);

        String[] temperatureStr = br.readLine().trim().split(" ");
        int[] temperatures = new int[temperatureStr.length];
        for (int i = 0; i < T; i++) {
            temperatures[i] = Integer.parseInt(temperatureStr[i]);
        }

        int maxTemp = Integer.MIN_VALUE;

        for (int i = 0; i <= temperatures.length - K; i++) {
            int maxSum = 0;
            for (int j = i; j < i + K; j++) {
                maxSum += temperatures[j];
            }
            maxTemp = Math.max(maxSum, maxTemp);
        }

        sb.append(maxTemp);
        bw.write(sb.toString());
        bw.close();
    }
}

