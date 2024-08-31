import java.io.*;

public class G2580 {

    static int[][] sudokuTable;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        N = 9;
        sudokuTable = new int[N][N];

        for (int r = 0; r < N; r++) {
            String[] numStr = br.readLine().trim().split(" ");
            for (int c = 0; c < N; c++) {
                sudokuTable[r][c] = Integer.parseInt(numStr[c]);
            }
        }

        solve(0, 0);

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                sb.append(sudokuTable[r][c]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    static boolean solve(int rowIdx, int colIdx) {
        if (rowIdx == N) {
            colIdx++;
            if (colIdx == N) return true;
            else rowIdx = 0;
        }

        if (sudokuTable[rowIdx][colIdx] != 0) return solve(rowIdx+1, colIdx);

        for (int num = 1; num <= N; num++) {
            if (isValid(rowIdx, colIdx, num)) {
                sudokuTable[rowIdx][colIdx] = num;

                if (solve(rowIdx+1, colIdx)) return true;

                sudokuTable[rowIdx][colIdx] = 0;
            }
        }

        return false;
    }

    private static boolean isValid(int rowIdx, int colIdx, int num) {
        for (int r = 0; r < N; r++) {
            if (sudokuTable[r][colIdx] == num) return false;
        }

        for (int c = 0; c < N; c++) {
            if (sudokuTable[rowIdx][c] == num) return false;
        }

        int boxRowOffset = (rowIdx / 3) * 3;
        int boxColumnOffset = (colIdx / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudokuTable[boxRowOffset + i][boxColumnOffset + j] == num) return false;
            }
        }

        return true;

    }
}
