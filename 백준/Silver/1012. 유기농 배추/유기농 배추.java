import java.io.*;

public class Main {

    static int M, N;
    static int[][] ground;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] s= br.readLine().trim().split(" ");
            M = Integer.parseInt(s[0]);
            N = Integer.parseInt(s[1]);
            int K = Integer.parseInt(s[2]);

            ground = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                ground[a][b] = 1;
            }

            int cnt = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (ground[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(cnt).append("\n");

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr > M -1 || nc < 0 || nc > N - 1 || visited[nr][nc]) continue;

            if (ground[nr][nc] == 1) dfs(nr, nc);
        }

    }

}
