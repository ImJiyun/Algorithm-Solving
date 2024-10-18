import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        String[] firstLine = br.readLine().trim().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        int[][] board = new int[N][N];
        int[][] prefixSum = new int[N][N];

        for (int r = 0; r < N; r++) {
            String[] nums = br.readLine().trim().split(" ");
            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(nums[c]);
                if (c == 0) prefixSum[r][c] = board[r][c];
                else prefixSum[r][c] = prefixSum[r][c-1] + board[r][c];
            }
        }

        for (int c = 0; c <  N; c++) {
            for (int r = 1; r < N; r++) {
                prefixSum[r][c] += prefixSum[r-1][c];
            }
        }


        for (int i = 0; i < M; i++) {
            String[] fourPoints = br.readLine().trim().split(" ");
            int x1 = Integer.parseInt(fourPoints[0]) - 1;
            int y1 = Integer.parseInt(fourPoints[1]) - 1;
            int x2 = Integer.parseInt(fourPoints[2]) - 1;
            int y2 = Integer.parseInt(fourPoints[3]) - 1;

            int result = prefixSum[x2][y2];
            if (x1 > 0) result -= prefixSum[x1-1][y2];
            if (y1 > 0) result -= prefixSum[x2][y1-1];
            if (x1 > 0 && y1 > 0) result += prefixSum[x1-1][y1-1];

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.close();

    }
}

