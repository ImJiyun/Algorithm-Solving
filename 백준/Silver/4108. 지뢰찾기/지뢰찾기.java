import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1}; // 상 하 좌 우 좌상 좌하 우상 우하
        int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};

        while (true) {
            String[] line = br.readLine().trim().split(" ");
            int R = Integer.parseInt(line[0]);
            int C = Integer.parseInt(line[1]);
            if (R == 0 && C == 0) break;

            char[][] map = new char[R][C];

            for (int r = 0; r < R; r++) {
                String s = br.readLine().trim();
                for (int c = 0; c < C; c++) {
                    map[r][c] = s.charAt(c);
                }
            }

            int[][] count = new int[R][C];

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c] == '.') {
                        for (int d = 0; d < 8; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            if (nr < 0 || nr > R - 1 || nc < 0 || nc > C - 1) continue;

                            if (map[nr][nc] == '*') count[r][c]++;
                        }
                    }
                }
            }

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c] == '*') sb.append('*');
                    else sb.append(count[r][c]);
                }
                sb.append("\n");
            }

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
