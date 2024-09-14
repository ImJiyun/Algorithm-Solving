import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        String[] line = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[][] garden = new int[N+1][M+1];

        String[] rowLine = br.readLine().trim().split(" ");
        int idx = 1;
        for (int r = 0; r < N; r++) {
            garden[idx++][0] = Integer.parseInt(rowLine[r]);
        }

        idx = 1;
        String[] colLine = br.readLine().trim().split(" ");
        for (int c = 0; c < M; c++) {
            garden[0][idx++] = Integer.parseInt(colLine[c]);
        }

        for (int r = 1; r <= N; r++) {
            for (int c= 1; c <= M; c++) {
                garden[r][c] = garden[r-1][c] == garden[r][c-1] ? 0 : 1;
            }
        }

        sb.append(garden[N][M]);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
