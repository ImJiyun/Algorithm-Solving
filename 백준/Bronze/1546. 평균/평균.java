import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int N = Integer.parseInt(br.readLine().trim());
        double[] nums = new double[N];

        String[] s = br.readLine().trim().split(" ");

        double max = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(s[i]);
            if (nums[i] >= max) max = nums[i];
        }

        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i] / max * 100;
        }

        sb.append(sum / N).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
