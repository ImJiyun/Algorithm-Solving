import java.io.*;

// 기본적으로 10163번 색종이와 같은 아이디어
public class S2563 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input2563.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int[][] arr = new int[100][100];

        // N : 색종이의 개수
        int N = Integer.parseInt(br.readLine().trim());

        // 색종이의 개수만큼 반복한다.
        for (int n = 1; n <= N; n++) {
            String[] line = br.readLine().trim().split(" ");

            // a : 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
            int a = Integer.parseInt(line[0]);
            // b : 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리
            int b = Integer.parseInt(line[1]);

            // 주어진 영역만큼 색종이의 번호로 바꾸기
            for (int x = a; x < a + 10; x++) {
                for (int y = b; y < b + 10; y++) {
                    arr[x][y] = n;
                }
            }
        }

        // 각 번호의 개수를 셀 count 배열
        int[] count = new int[N + 1];

        // 개수를 센다.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                count[arr[i][j]]++;
            }
        }

        // 누적합 배열을 만든다.
        // 인덱스 1번부터의 누적합 배열을 만든다.
        for (int i = 2; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // 누적합 배열의 마지막 인덱스가 영역의 넓이
        sb.append(count[count.length - 1]);
        bw.write(sb.toString());
        bw.close();
    }
}
