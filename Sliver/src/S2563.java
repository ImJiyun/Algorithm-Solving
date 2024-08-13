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

            // 주어진 영역만큼 1로 바꾸기
            for (int x = a; x < a + 10; x++) {
                for (int y = b; y < b + 10; y++) {
                    arr[x][y] = 1;
                }
            }
        }

        // count : 1의 개수를 센다.
        int count = 0;

        // 개수를 센다.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) count++;
            }
        }


        sb.append(count);
        bw.write(sb.toString());
        bw.close();
    }
}
