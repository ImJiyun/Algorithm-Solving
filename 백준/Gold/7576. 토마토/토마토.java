import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int M, N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");

        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            s = br.readLine().trim().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        Queue<int[]> q = new LinkedList<>();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        bfs(q);
        boolean hasZero = false;
        int maxDate = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDate = Math.max(maxDate, arr[i][j]);
                if (arr[i][j] == 0) {
                    hasZero = true;
                    break;
                }
            }
        }

        if (hasZero) sb.append(-1);
        else if (maxDate == 1) sb.append(0);
        else sb.append(maxDate - 1);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void bfs(Queue<int[]> q) {

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;

                    if (arr[nr][nc] == 0) {
                        arr[nr][nc] = arr[r][c] + 1;
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }

                }

            }

        }

    }
}
