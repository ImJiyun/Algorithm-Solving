import java.io.*;

public class Main {
    static int N;
    static char[][] paintings;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine().trim());
        paintings = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                paintings[i][j] = s.charAt(j);
            }
        }

        int count1 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count1++;
                    dfs(i, j, paintings[i][j], false);
                }
            }
        }

        int count2 = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count2++;
                    dfs(i, j, paintings[i][j], true);
                }
            }
        }

        sb.append(count1).append(" ").append(count2);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int r, int c, char color, boolean isBlind) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;
            if (isBlind) {
                if ((color == 'G' && paintings[nr][nc] == 'R') || color == 'R' && paintings[nr][nc] == 'G') dfs(nr, nc, paintings[nr][nc], true);
                else if (paintings[nr][nc] == color) dfs(nr, nc, paintings[nr][nc], true);

            } else {
                if (paintings[nr][nc] == color) dfs(nr, nc, paintings[nr][nc], false);
            }
        }
    }
}
