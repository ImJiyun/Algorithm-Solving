import java.io.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];

        int max = 0;

        for (int r = 0; r < N; r++) {
            String[] line = br.readLine().trim().split(" ");
            for (int c = 0; c < N; c++) {
                int curr = Integer.parseInt(line[c]);
                map[r][c] = curr;
                max = Math.max(max, curr);
            }
        }

        int totalCnt = 0;

        for (int i = 0; i <= max; i++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] <= i) map[r][c] = 0;
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] != 0 && !visited[r][c]) {
                        cnt++;
                        dfs(r, c);
                    }
                }
            }
            totalCnt = Math.max(totalCnt, cnt);
        }

        sb.append(totalCnt);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1) continue;
            if (map[nr][nc] != 0 && !visited[nr][nc]) dfs(nr, nc);
        }
    }
}
