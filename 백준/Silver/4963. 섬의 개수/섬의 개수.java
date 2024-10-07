import java.io.*;

public class Main {

    static int w, h;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        while (true) {
            String[] s= br.readLine().trim().split(" ");
            w = Integer.parseInt(s[0]);
            h = Integer.parseInt(s[1]);

            if (w == 0 && h == 0) break;

            arr = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                s = br.readLine().trim().split(" ");
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }
            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        count++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int d = 0; d < 8; d++) {
            int nx = x + dr[d];
            int ny = y + dc[d];

            if (nx < 0 || ny < 0 || nx > h -1 || ny > w - 1) continue;
            if (arr[nx][ny] == 1 && !visited[nx][ny]) dfs(nx, ny);
        }
    }
}
