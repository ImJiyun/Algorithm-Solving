import java.io.*;

public class Main {

    static int N, curX, curY, ans;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = 5;
        arr = new int[N][N];

        for (int i = 0; i < 5; i++) {
            String[] s = br.readLine().trim().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        String[] s = br.readLine().trim().split(" ");
        curX = Integer.parseInt(s[0]);
        curY = Integer.parseInt(s[1]);

        ans = 0;

        dfs(curX, curY, 0, 0);

        sb.append(ans);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int x, int y, int depth, int cnt) {
        if (arr[x][y] == 1) cnt++;

        if (depth == 3) {
            if (cnt >= 2) ans = 1;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] == -1) continue;

            arr[x][y] = -1;
            dfs(nx, ny, depth + 1, cnt);
            arr[x][y] = 0; 
        }
    }
}
