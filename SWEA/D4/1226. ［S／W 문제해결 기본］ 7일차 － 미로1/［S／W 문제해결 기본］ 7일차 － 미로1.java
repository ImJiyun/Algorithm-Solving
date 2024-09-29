import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[][] maze;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("Maze1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = 10;

        for (int i = 0; i < T; i++) {
            int tc = Integer.parseInt(br.readLine().trim());
            maze = new int[16][16];

            visited = new boolean[16][16];

            for (int j = 0; j < 16; j++) {
                String[] line = br.readLine().trim().split("");
                for (int k = 0; k < 16; k++) {
                    maze[j][k] = Integer.parseInt(line[k]);
                }
            }

            int ans = 0;

            for (int j = 0; j < 16; j++) {
                for (int k = 0; k < 16; k++) {
                    if(maze[j][k] == 2) {
                        ans = bfs(j, k);
                        break;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int rowIdx, int colIdx) {
        Queue<int[]> q = new LinkedList<>();
        visited[rowIdx][colIdx] = true;
        q.offer(new int[]{rowIdx, colIdx});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nextRowIdx = cur[0] + dr[d];
                int nextColIdx = cur[1] + dc[d];

                if (nextRowIdx < 0 || nextRowIdx >= 16 || nextColIdx < 0 || nextColIdx >= 16) continue;
                if (visited[nextRowIdx][nextColIdx]) continue;
                if (maze[nextRowIdx][nextColIdx] == 3) return 1;
                if (maze[nextRowIdx][nextColIdx] == 0) {
                    visited[nextRowIdx][nextColIdx] = true;
                    q.offer(new int[]{nextRowIdx, nextColIdx});
                }
            }

        }
        return 0;
    }
}
