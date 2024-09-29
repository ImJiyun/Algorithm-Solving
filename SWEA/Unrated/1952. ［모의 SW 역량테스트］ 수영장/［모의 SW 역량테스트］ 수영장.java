import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("SwimmingPool.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            String[] s1 = br.readLine().trim().split(" ");
            // 가격 입력 받기
            int[] prices = new int[4];
            for (int i = 0; i < 4; i++) {
                prices[i] = Integer.parseInt(s1[i]);
            }
            String[] s2 = br.readLine().trim().split(" ");
            int[] plans = new int[13];

            int idx = 1;
            for (int i = 0; i < 12; i++) {
                plans[idx++] = Integer.parseInt(s2[i]);
            }

            int[] dp = new int[13];
            for (int i = 1; i < 13; i++) {
                dp[i] = dp[i - 1] + prices[0] * plans[i];

                dp[i] = Math.min(dp[i], dp[i - 1] + prices[1]);

                if (i >= 3) dp[i] = Math.min(dp[i], dp[i - 3] + prices[2]);
            }

            int result = Math.min(dp[12], prices[3]);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
