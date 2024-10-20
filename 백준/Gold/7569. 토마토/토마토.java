import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int M, N, H;
    static int[][][] box;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0, 0, 0}; 
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");

        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        H = Integer.parseInt(s[2]);

        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                s = br.readLine().trim().split(" ");
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(s[k]);
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 1) {
                        visited[i][j][k] = true;
                        q.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        bfs(q);
        boolean hasZero = false;
        int maxDate = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    maxDate = Math.max(maxDate, box[i][j][k]);
                    if (box[i][j][k] == 0) {
                        hasZero = true;
                        break;
                    }
                }
            }
        }

        if (hasZero) sb.append(-1);
        else sb.append(maxDate - 1);

        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int h = cur[0];
            int r = cur[1];
            int c = cur[2];

            for (int d = 0; d < 6; d++) {
                int nh = h + dh[d];
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nh < 0 || nr < 0 || nc < 0 || nh >= H || nr >= N || nc >= M) continue;

                if (box[nh][nr][nc] == 0) {
                    visited[nh][nr][nc] = true;
                    box[nh][nr][nc] = box[h][r][c] + 1;
                    q.offer(new int[]{nh, nr, nc});
                }
            }
        }
    }
}
