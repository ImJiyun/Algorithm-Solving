import java.io.*;

public class Main {

    static int N, M, r, c, d, cnt;
    static int[][] room;
    static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dc = {0, 1, 0, -1};

    // 북쪽을 바라보면 남쪽으로 후진 0-> 2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        room = new int[N][M];

        s = br.readLine().trim().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        d = Integer.parseInt(s[2]);


        for (int i = 0; i < N; i++) {
            s = br.readLine().trim().split(" ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(s[j]);
            }
        }

        cnt = 1;

        clean(r, c, d);

        sb.append(cnt);
        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    static void clean(int rowIdx, int colIdx, int dir) {
        room[rowIdx][colIdx] = -1; // 로봇청소기가 있는 칸은 항상 빈칸

        for (int d = 0; d < 4; d++) {
            dir = (dir + 3) % 4; // 반시계 회전

            int nextRowIdx = rowIdx + dr[dir];
            int nextColIdx = colIdx + dc[dir];

            if (nextRowIdx < 0 || nextRowIdx >= N || nextColIdx < 0 || nextColIdx >= M || room[nextRowIdx][nextColIdx] == 1) continue;

            if (room[nextRowIdx][nextColIdx] == 0) {
                cnt++;
                clean(nextRowIdx, nextColIdx, dir);
                return;
            }
        }

        int d = (dir + 2) % 4;
        int nextRowIdx = rowIdx + dr[d];
        int nextColIdx = colIdx + dc[d];
        if (nextRowIdx >= 0 && nextRowIdx < N && nextColIdx >= 0 && nextColIdx < M && room[nextRowIdx][nextColIdx] != 1) clean(nextRowIdx, nextColIdx, dir);
    }
}
