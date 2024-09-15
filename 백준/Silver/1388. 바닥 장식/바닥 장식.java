import java.io.*;

public class Main {

    static int N, M;
    static char[][] shape;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        shape = new char[N][M];
        visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            String s2 = br.readLine().trim();
            for (int c = 0; c < M; c++) {
                shape[r][c] = s2.charAt(c);
            }
        }

        int count = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!visited[r][c]) {
                    dfs(r, c, shape[r][c]);
                    count++;
                }
            }
        }

        sb.append(count);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int rowIdx, int colIdx, char mark) {

        visited[rowIdx][colIdx] = true;
        int nextRowIdx, nextColIdx;
        if (mark == '-') {
            nextRowIdx = rowIdx;
            nextColIdx = colIdx + 1;
        } else {
            nextRowIdx = rowIdx + 1;
            nextColIdx = colIdx;
        }

        if (nextRowIdx > N - 1 || nextColIdx > M - 1) {
            return;
        }

        if (visited[nextRowIdx][nextColIdx]) return;

        if (shape[nextRowIdx][nextColIdx] == mark) dfs(nextRowIdx, nextColIdx, mark);
    }
}
