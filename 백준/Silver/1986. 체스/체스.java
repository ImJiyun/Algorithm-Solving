import java.io.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int N, M, K;
    static int[][] chessBoard;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        String[] firstLine = br.readLine().trim().split(" ");

        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        K = Math.max(N, M);

        chessBoard = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < 3; i++) {
            String[] line = br.readLine().trim().split(" ");
            int num = i + 1; // 1 : Queen, 2 L Knight, 3 : Pawn
            for (int j = 1; j < line.length; j+=2) {
                chessBoard[Integer.parseInt(line[j]) - 1][Integer.parseInt(line[j+1]) - 1] = num;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (chessBoard[i][j] == 1) checkQueen(i, j);
                else if (chessBoard[i][j] == 2) checkKnight(i, j);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (chessBoard[i][j] != 0) continue;
                if (!visited[i][j]) count++;
            }
        }

        sb.append(count);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void checkKnight(int rowIdx, int colIdx) {
        for (int i = 0; i < 8; i++) {
            int nextRowIdx = rowIdx + dx[i];
            int nextColIdx = colIdx + dy[i];
            if (nextRowIdx < 0 || nextRowIdx >= N || nextColIdx < 0 || nextColIdx >= M) continue;
            if (chessBoard[nextRowIdx][nextColIdx] != 0) continue;
            visited[nextRowIdx][nextColIdx] = true;
        }
    }

    static void checkQueen(int rowIdx, int colIdx) {
        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < K; j++) {
                int nextRowIdx = rowIdx + dr[i] * j;
                int nextColIdx = colIdx + dc[i] * j;
                if (nextRowIdx < 0 || nextRowIdx >= N || nextColIdx < 0 || nextColIdx >= M) break;
                if (chessBoard[nextRowIdx][nextColIdx] != 0) break;
                visited[nextRowIdx][nextColIdx] = true;
            }
        }
    }
}
