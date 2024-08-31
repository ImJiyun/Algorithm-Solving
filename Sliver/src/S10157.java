import java.io.*;

// 달팽이 배열 풀이법
public class S10157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        String[] firstLine = br.readLine().trim().split(" ");
        // C : 가로 칸 개수 (열)
        int C = Integer.parseInt(firstLine[0]);
        // R : 세로 칸 개수 (행)
        int R = Integer.parseInt(firstLine[1]);
        // K : 관객의 대기 번호
        int K = Integer.parseInt(br.readLine().trim());

        // R * C 배열 생성
        int[][] arr = new int[R][C];

        // 상 우 하 좌
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        // 델타 배열 인덱스
        int d = 0;

        // 시작 값 1
        int count = 1;

        // 시작 인덱스
        int rowIdx = R - 1; // 행의 마지막 인덱스
        int colIdx = 0; // 열의 0번째 인덱스


        // 관객의 대기 번호가 수용 가능한 번호(C * R)보다 클 경우
        if (K > C * R) {
            sb.append(0); // sb에 0 추가
        } else {
            // count 값이 C * R 될 때까지 반복
            while (count <= C * R) {
                // 현재 인덱스 값에 count 값 넣기
                arr[rowIdx][colIdx] = count++; // 후에 count 1 증가

                // 다음 인덱스의 값 구하기
                int nextRowIdx = rowIdx + deltaRow[d];
                int nextColIdx = colIdx + deltaCol[d];

                // 다음 인덱스가 배열의 범위를 넘어가거나, 해당 인덱스의 값이 0일 경우
                if (nextRowIdx < 0 || nextRowIdx > R - 1 || nextColIdx < 0 || nextColIdx > C - 1 ||
                        arr[nextRowIdx][nextColIdx] != 0) {
                    d = (d+1) % 4; // 방향을 바꾼다.
                    nextRowIdx = rowIdx + deltaRow[d];
                    nextColIdx = colIdx + deltaCol[d];
                }
                // 다음 인덱스로 위치를 바꾼다.
                rowIdx = nextRowIdx;
                colIdx = nextColIdx;
            }

            // 배열을 순회하면서
            for (int r = 0; r < arr.length; r++) {
                for (int c = 0; c < arr[r].length; c++) {
                    // 해당 인덱스의 값이 대기 번호의 값과 일치하면
                    if (arr[r][c] == K) {
                        // sb에 추가
                        sb.append(c+1).append(" ").append(R -r);
                        break;
                    }
                }
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}

