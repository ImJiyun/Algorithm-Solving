import java.io.*;

public class Solution {

    static int[][] magnets;
    static int[] rotateDirections; // 각 자석의 회전 방향을 기록하는 배열

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("SWEA_4013_특이한자석.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine().trim());

            magnets = new int[4][8];

            for (int i = 0; i < 4; i++) {
                String[] line = br.readLine().trim().split(" ");
                for (int j = 0; j < 8; j++) {
                    magnets[i][j] = Integer.parseInt(line[j]);
                }
            }

            for (int i = 0; i < K; i++) {
                String[] line = br.readLine().trim().split(" ");
                int num = Integer.parseInt(line[0]) - 1; // 0-based index로 변환
                int direction = Integer.parseInt(line[1]);

                // 각 자석의 회전 방향을 초기화 (-1: 반시계, 1: 시계, 0: 회전 안함)
                rotateDirections = new int[4];
                rotateDirections[num] = direction;

                // 자석 회전 방향 결정
                checkRotation(num);

                // 자석 회전 실행
                rotateAll();
            }

            int ans = 0;

            if (magnets[0][0] == 1) ans += 1;
            if (magnets[1][0] == 1) ans += 2;
            if (magnets[2][0] == 1) ans += 4;
            if (magnets[3][0] == 1) ans += 8;

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void checkRotation(int num) {
        // 오른쪽 자석 회전 여부 결정
        for (int i = num; i < 3; i++) {
            if (magnets[i][2] != magnets[i + 1][6]) {
                rotateDirections[i + 1] = -rotateDirections[i];
            } else {
                break; // 같은 극이라면 그 이후 자석은 회전 안함
            }
        }

        // 왼쪽 자석 회전 여부 결정
        for (int i = num; i > 0; i--) {
            if (magnets[i][6] != magnets[i - 1][2]) {
                rotateDirections[i - 1] = -rotateDirections[i];
            } else {
                break; // 같은 극이라면 그 이후 자석은 회전 안함
            }
        }
    }

    static void rotateAll() {
        // 모든 자석을 회전시키는 함수
        for (int i = 0; i < 4; i++) {
            if (rotateDirections[i] != 0) {
                rotateMagnets(i, rotateDirections[i]);
            }
        }
    }

    static void rotateMagnets(int num, int direction) {
        int[] magnet = magnets[num];
        if (direction == 1) { // 시계 방향
            int tmp = magnet[7];
            for (int i = 7; i > 0; i--) {
                magnet[i] = magnet[i - 1];
            }
            magnet[0] = tmp;
        } else { // 반시계 방향
            int tmp = magnet[0];
            for (int i = 0; i < 7; i++) {
                magnet[i] = magnet[i + 1];
            }
            magnet[7] = tmp;
        }
    }
}
