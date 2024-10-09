import java.io.*;

public class Main {

    static int N, M, cnt;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        int totalCnt = 0;
        int maxCnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cnt = 0;
                if (arr[i][j] == 1 && !visited[i][j]) {
                    totalCnt++;
                    dfs(i, j);
                    maxCnt = Math.max(maxCnt, cnt);
                }
            }
        }

        sb.append(totalCnt).append("\n").append(maxCnt);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        cnt++;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1 || visited[nr][nc]) continue;

            if (arr[nr][nc] == 1) dfs(nr, nc);
        }
    }
}
