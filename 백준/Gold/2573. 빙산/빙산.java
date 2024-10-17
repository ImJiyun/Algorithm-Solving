import java.io.*;

public class Main {

    static int N, M;
    static int[][] ocean, zeroCnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        ocean = new int[N][M];
        zeroCnt = new int[N][M];

        for (int i = 0; i < N; i++) {
            s = br.readLine().trim().split(" ");
            for (int j = 0; j < M; j++) {
                ocean[i][j] = Integer.parseInt(s[j]);
            }
        }

        int time = 0;
        while (true) {
            int cnt = countIcebergs();
            if (cnt >= 2) {
                sb.append(time);
                break;
            }
            if (cnt == 0) {
                sb.append(0);
                break;
            }

            meltIcebergs();
            time++;
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int countIcebergs() {
        visited = new boolean[N][M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ocean[i][j] > 0 && !visited[i][j]) {
                    cnt++;
                    dfs(i, j); 
                }
            }
        }
        return cnt;
    }

    static void meltIcebergs() {
        zeroCnt = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ocean[i][j] > 0) {
                    zeroCnt[i][j] = check(i, j);  
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ocean[i][j] > 0) {
                    ocean[i][j] = Math.max(ocean[i][j] - zeroCnt[i][j], 0);  
                }
            }
        }
    }

    static int check(int r, int c) {
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nc >= 0 && nr < N && nc < M && ocean[nr][nc] == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || ocean[nr][nc] == 0) continue;
            dfs(nr, nc);
        }
    }
}
