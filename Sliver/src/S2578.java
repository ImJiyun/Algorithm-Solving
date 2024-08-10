import java.io.*;

public class S2578 {

    static int[][] board = new int[5][5];
    static int lineCount = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input2578.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        // 빙고판을 입력 받는 코드
        for (int i = 0; i < 5; i++) {
            String[] line = br.readLine().trim().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        int count = 0;
        boolean isBingo = false;

        // 사회자가 숫자를 부른다.
        for (int i = 0; i < 5 && !isBingo; i++) {
            String[] line = br.readLine().trim().split(" ");
            for (int j = 0; j < 5 && !isBingo; j++) {
                count++;
                // 사회자가 부른 숫자
                int num = Integer.parseInt(line[j]);

                // 빙고판에서 숫자 찾아서 0으로 바꾸기
                for (int r = 0; r < 5; r++) {
                    for (int c = 0; c < 5; c++) {
                        if (board[r][c] == num) {
                            board[r][c] = 0;
                            // 한 줄이 되었을 때 lineCount를 1 증가시키는 메서드
                            checkOneLine(r, c);
                            // 빙고인지 확인
                            if (checkBingo()) {
                                isBingo = true;
                            }
                            break;
                        }
                    }
                    if (isBingo) break;
                }
            }
        }

        sb.append(count);
        bw.write(sb.toString());
        bw.close();
    }

    static void checkOneLine(int i, int j) {
        // 가로 체크
        boolean rowOneLine = true;
        for (int c = 0; c < 5; c++) {
            if (board[i][c] != 0) {
                rowOneLine = false;
                break;
            }
        }
        if (rowOneLine) lineCount++;

        // 세로 체크
        boolean colOneLine = true;
        for (int r = 0; r < 5; r++) {
            if (board[r][j] != 0) {
                colOneLine = false;
                break;
            }
        }
        if (colOneLine) lineCount++;

        // 대각선 체크 (왼쪽 상단에서 오른쪽 하단)
        if (i == j) {
            boolean diagOneLine = true;
            for (int x = 0; x < 5; x++) {
                if (board[x][x] != 0) {
                    diagOneLine = false;
                    break;
                }
            }
            if (diagOneLine) lineCount++;
        }

        // 반대 대각선 체크 (오른쪽 상단에서 왼쪽 하단)
        if (i + j == 4) {
            boolean antiDiagOneLine = true;
            for (int x = 0; x < 5; x++) {
                if (board[x][4 - x] != 0) {
                    antiDiagOneLine = false;
                    break;
                }
            }
            if (antiDiagOneLine) lineCount++;
        }
    }

    static boolean checkBingo() {
        return lineCount >= 3;
    }
}