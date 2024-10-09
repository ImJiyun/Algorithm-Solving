import java.io.*;

public class Main {

    static int N, M, cnt;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");
        N = Integer.parseInt(s[0]); // 가로
        M = Integer.parseInt(s[1]); // 세로

        map = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int totalWhiteCnt = 0;
        int totalBlueCnt = 0;


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt = 0;
                    dfs(i, j, map[i][j]);

                    if (map[i][j] == 'W') totalWhiteCnt += cnt * cnt;
                    else totalBlueCnt += cnt * cnt;
                }
            }
        }

        sb.append(totalWhiteCnt).append(" ").append(totalBlueCnt).append("\n");
        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    static void dfs(int r, int c, char mark) {
        visited[r][c] = true;
        cnt++;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr > M - 1 || nc < 0 || nc > N - 1 || visited[nr][nc]) continue;

            if (map[nr][nc] == mark) {

                dfs(nr, nc, mark);
            }
        }

    }
}
