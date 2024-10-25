import java.io.*;

public class Main {

    static int R, C, max;
    static char[][] board;
    static boolean[] visitedAlphabets = new boolean[26];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);

        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s1 = br.readLine().trim();
            for (int j = 0; j < C; j++) {
                board[i][j] = s1.charAt(j);
            }
        }

        max = 1;
        visitedAlphabets[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int r, int c, int cnt) {
        max = Math.max(max, cnt);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc]) continue;
            int alphabetIndex = board[nr][nc] - 'A';
            if (!visitedAlphabets[alphabetIndex]) {
                visitedAlphabets[alphabetIndex] = true;
                dfs(nr, nc, cnt + 1);
                visitedAlphabets[alphabetIndex] = false;
            }
        }
    }
}
