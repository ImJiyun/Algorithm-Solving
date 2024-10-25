import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, desR, desC;
    static int[][] ground;
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

        ground = new int[N][M];
        visited = new boolean[N][M];
        desR = 0;
        desC = 0;

        for (int i = 0; i < N; i++) {
            s = br.readLine().trim().split(" ");
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(s[j]);
                if (ground[i][j] == 2) {
                    desR = i;
                    desC = j;
                }
            }
        }

        bfs(desR, desC);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ground[i][j] == 1 && !visited[i][j]) {
                    ground[i][j] = -1;
                }
                sb.append(ground[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;
        ground[r][c] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0], col = cur[1];

            for (int d = 0; d < 4; d++) {
                int nextRow = row + dr[d], nextCol = col + dc[d];
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M
                        || visited[nextRow][nextCol] || ground[nextRow][nextCol] == 0) continue;

                if (ground[nextRow][nextCol] == 1) {
                    visited[nextRow][nextCol] = true;
                    ground[nextRow][nextCol] = ground[row][col] + 1;
                    q.offer(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}
