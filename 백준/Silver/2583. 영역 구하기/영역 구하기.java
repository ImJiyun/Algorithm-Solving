import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int M, N, cnt;
    static int[][] map;
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
        int K = Integer.parseInt(s[2]);

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            s = br.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            int b1 = Integer.parseInt(s[1]);
            int a2 = Integer.parseInt(s[2]) - 1;
            int b2 = Integer.parseInt(s[3]) - 1;

            for (int j = b1; j <= b2; j++) {
                for (int k = a1; k <= a2; k++) {
                    map[j][k] = 1;
                }
            }

        }

        List<Integer> list = new ArrayList<>();
        int totalCnt = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    cnt = 0;
                    totalCnt++;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }

        sb.append(totalCnt).append("\n");

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }

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

            if (nr < 0 || nc < 0 || nr > M - 1 || nc > N - 1 || visited[nr][nc]) continue;

            if (map[nr][nc] == 0) {
                dfs(nr, nc);
            }
        }
    }
}
