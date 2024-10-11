import java.io.*;
import java.util.*;

public class Main {

    static int N, curX, curY, desX, desY;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            map = new int[N][N];
            visited = new boolean[N][N];

            String[] s = br.readLine().trim().split(" ");
            curX = Integer.parseInt(s[0]);
            curY = Integer.parseInt(s[1]);

            s = br.readLine().trim().split(" ");
            desX = Integer.parseInt(s[0]);
            desY = Integer.parseInt(s[1]);

            int ans = bfs(curX, curY);

            sb.append(ans).append("\n");

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int cnt = cur[2];

            if (curX == desX && curY == desY) {
                return cnt;
            }

            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        return -1;  
    }
}
