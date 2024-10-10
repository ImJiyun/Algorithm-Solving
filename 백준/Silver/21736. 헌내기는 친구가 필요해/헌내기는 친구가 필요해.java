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

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'I') {
                    dfs(i, j);
                    break;
                }
            }
        }

        if (cnt == 0) sb.append("TT");
        else sb.append(cnt);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;

        if (map[r][c] == 'P') cnt++;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1 || visited[nr][nc] || map[nr][nc] == 'X') continue;

            dfs(nr, nc);
        }
    }
}
