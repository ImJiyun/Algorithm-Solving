import java.io.*;

public class Solution {

    static int[][] chessTable; // 체스 판
    static int N; // 퀸 개수
    static int count; // 정답 카운트

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/김지윤/input_A057.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            count = 0;

            chessTable = new int[N][N];

            setQueens(0);
            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    static void setQueens(int colIdx) {
        if (colIdx == N) { // 모든 열에 퀸을 다 놓았다면
            count++; // 정답 카운트 1 증가
            return; // true 반환
        }

        for (int rowIdx = 0; rowIdx < N; rowIdx++) {
            if (isPlaceValid(rowIdx, colIdx)) { // 유효한 자리인지 확인
                chessTable[rowIdx][colIdx] = 1; // 맞다면 퀸 놓기

                setQueens(colIdx + 1); // 다음 열에 퀸 놓기

                chessTable[rowIdx][colIdx] = 0; // 백트래킹

            }
        }
    }

    static boolean isPlaceValid(int rowIdx, int colIdx) {
        // 같은 행에 퀸이 있는지 확인
        for (int c = 0; c < colIdx; c++) {
            if (chessTable[rowIdx][c] == 1) return false;
        }

        // 열 체크는 필요 없음

        // 대각선 확인 (왼쪽 위로 이동하면서 확인)
        for (int r = rowIdx, c = colIdx; r >= 0 && c >= 0; r--, c--) {
            if (chessTable[r][c] == 1) return false;
        }

        // 대각선 확인 (오른쪽 아래로 확인하면서 확인)
        for (int r = rowIdx, c = colIdx; r < chessTable.length && c >= 0; r++, c--) {
            if (chessTable[r][c] == 1) return false;
        }

        return true;

    }
}
