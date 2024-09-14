import java.io.*;

public class Main {

    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        board = new char[3][3];

        int player = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < 9; i++) {
            String[] points = br.readLine().trim().split(" ");
            int rowIdx = Integer.parseInt(points[0]) - 1;
            int colIdx = Integer.parseInt(points[1]) - 1;

            char mark = (player == 1) ? 'O' : 'X';
            board[rowIdx][colIdx] = mark;

            if (hasOneLine(rowIdx, colIdx, mark)) {
                sb.append(player);
                break;
            }

            player = 3 - player;
        }

        if (sb.length() == 0) sb.append(0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static boolean hasOneLine(int rowIdx, int colIdx, char mark) {
        // 가로 체크
        if (board[rowIdx][0] == mark && board[rowIdx][1] == mark && board[rowIdx][2] == mark) return true;
        // 세로 체크
        if (board[0][colIdx] == mark && board[1][colIdx] == mark && board[2][colIdx] == mark) return true;
        // 대각선 체크 (좌상단 -> 우하단)
        if (rowIdx == colIdx && board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) return true;
        // 대각선 체크 (우상단 -> 좌하단)
        if (rowIdx + colIdx == 2 && board[0][2] == mark && board[1][1] == mark && board[2][0] == mark) return true;

        return false;
    }
}
