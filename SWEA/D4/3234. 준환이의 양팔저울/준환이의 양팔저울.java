import java.io.*;

public class Solution {

    static int ans;

    public static void main(String[] args) throws IOException {
        // long start = System.currentTimeMillis();
        // System.setIn(new FileInputStream("input3.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());

            int[] weights = new int[N];
            boolean[] visited = new boolean[N];
            ans = 0;


            String[] weightStr = br.readLine().trim().split(" ");

            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(weightStr[i]);
            }

            putWeights(0, 0, 0, N, weights, visited);

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        bw.write(sb.toString());
        // long estimated = System.currentTimeMillis() - start;
        // System.out.println(estimated);
        bw.close();
        br.close();


    }

    static void putWeights(int count, int left, int right, int N, int[] weights, boolean[] visited) {

        if (left < right) return;

        if (count == N) {
            ans++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                putWeights(count + 1, left + weights[i], right, N, weights, visited);
                putWeights(count + 1, left, right + weights[i], N, weights, visited);
                visited[i] = false;
            }
        }
    }

}
