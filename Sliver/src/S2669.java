import java.io.*;

// 10163번, 2563번 색종이와 같은 아이디어
public class S2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        // 직사각형들의 면적을 표시할 배열
        int[][] arr = new int[100][100];
        // 직사각형의 총 개수 4개
        int N = 4;

        // N만큼 반복
        for (int n = 1; n <= 4; n++) {
            // 한 줄 입력받기
            String[] line = br.readLine().trim().split(" ");
            // x1: 왼쪽 아래 꼭짓점 x좌표
            int x1 = Integer.parseInt(line[0]);
            // y1: 왼쪽 아래 꼭짓점 y좌표
            int y1 = Integer.parseInt(line[1]);
            // x2: 오른쪽 위 꼭짓점 x좌표
            int x2 = Integer.parseInt(line[2]);
            // y2: 오른쪽 위 꼭짓점 y좌표
            int y2 = Integer.parseInt(line[3]);

            // x1 ~ x2
            for (int x = x1; x < x2; x++) {
                // y1 ~ y2
                for (int y = y1; y < y2; y++) {
                    // arr[x][y]를 n(직사각형 번호)으로 바꿔준다
                    arr[x][y] = n;
                }
            }
        }

        // 각 직사각형의 개수를 구할 배열
        int[] count = new int[N + 1];

        // 번호가 몇 번씩 나왔는지 센다.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                count[arr[i][j]]++;
            }
        }

        // 인덱스 1번부터 누적합을 구한다.
        for (int i = 2; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // 마지막 인덱스의 값: 네 개의 직사각형이 차지하는 면적
        sb.append(count[count.length - 1]);
        bw.write(sb.toString());
        bw.close();
    }
}
