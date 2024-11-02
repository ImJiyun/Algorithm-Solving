import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");
        N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        s = br.readLine().trim().split(" ");
        int myX = Integer.parseInt(s[0]) - 1;  
        int myY = Integer.parseInt(s[1]) - 1;

        int[][] targets = new int[M][2];
        for (int i = 0; i < M; i++) {
            s = br.readLine().trim().split(" ");
            targets[i][0] = Integer.parseInt(s[0]) - 1;
            targets[i][1] = Integer.parseInt(s[1]) - 1;
        }

        int[][] distances = bfs(myX, myY, targets);

        // 목표 지점까지의 거리 출력
        for (int i = 0; i < M; i++) {
            int targetX = targets[i][0];
            int targetY = targets[i][1];
            sb.append(distances[targetX][targetY]).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }

    static int[][] bfs(int startX, int startY, int[][] targets) {
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        board[startX][startY] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = board[x][y];

            for (int d = 0; d < 8; d++) {
                int newX = x + dr[d];
                int newY = y + dc[d];

                if (newX >= 0 && newX < N && newY >= 0 && newY < N && board[newX][newY] == -1) {
                    board[newX][newY] = cnt + 1;
                    q.offer(new int[]{newX, newY});
                }
            }
        }

        return board;
    }
}
