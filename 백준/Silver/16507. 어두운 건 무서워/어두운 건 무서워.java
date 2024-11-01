import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");
        int R = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);
        int Q = Integer.parseInt(s[2]);

        int[][] picture = new int[R][C];

        for (int i = 0; i < R; i++) {
            s = br.readLine().trim().split(" ");
            for (int j = 0; j < C; j++) {
                picture[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 1; j < C; j++) {
                picture[i][j] += picture[i][j - 1];
            }
        }

        for (int j = 0; j < C; j++) {
            for (int i = 1; i < R; i++) {
                picture[i][j] += picture[i - 1][j];
            }
        }

        for (int i = 0; i < Q; i++) {
            s = br.readLine().trim().split(" ");
            int r1 = Integer.parseInt(s[0]) - 1;
            int c1 = Integer.parseInt(s[1]) - 1;
            int r2 = Integer.parseInt(s[2]) - 1;
            int c2 = Integer.parseInt(s[3]) - 1;

            int sum = picture[r2][c2];
            if (r1 > 0) sum -= picture[r1 - 1][c2];
            if (c1 > 0) sum -= picture[r2][c1 - 1];
            if (r1 > 0 && c1 > 0) sum += picture[r1 - 1][c1 - 1];

            int n = (r2 - r1 + 1) * (c2 - c1 + 1);
            sb.append(sum / n).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
