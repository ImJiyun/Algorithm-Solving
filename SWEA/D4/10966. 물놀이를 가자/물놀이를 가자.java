import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dc = {0, 1, 0, -1}; // 상 우 하 좌

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            N = Integer.parseInt(line[0]);
            M = Integer.parseInt(line[1]);

            map = new int[N][M];
            visited = new boolean[N][M];
            Queue<int[]> queue = new LinkedList<>();

            for (int r = 0; r < N; r++) {
                String WL = br.readLine().trim();
                for (int c = 0; c < M; c++) {
                    char character = WL.charAt(c);
                    if (character == 'L') {
                        map[r][c] = 0; // 땅이면 0으로 표시
                    } else {
                        map[r][c] = -1; // 물이면 -1로 표시
                        queue.offer(new int[]{r, c, 0}); // 물 위치를 큐에 추가
                        visited[r][c] = true; // 물 위치 방문 표시
                    }
                }
            }

            // BFS 실행
            bfs(queue);

            int ans = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == -1) continue;
                    ans += map[r][c];
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int rowIdx = info[0];
            int colIdx = info[1];
            int distance = info[2];

            for (int d = 0; d < 4; d++) {
                int nextRowIdx = rowIdx + dr[d];
                int nextColIdx = colIdx + dc[d];

                if (nextRowIdx < 0 || nextRowIdx >= N || nextColIdx < 0 || nextColIdx >= M) continue;
                if (visited[nextRowIdx][nextColIdx]) continue;

                visited[nextRowIdx][nextColIdx] = true;
                map[nextRowIdx][nextColIdx] = distance + 1;
                queue.offer(new int[]{nextRowIdx, nextColIdx, distance + 1});
            }
        }
    }
}