import java.io.*;

public class S10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        String[] firstLine = br.readLine().trim().split(" ");
        // 격자 공간 크기 w * h
        int w = Integer.parseInt(firstLine[0]);
        int h = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().trim().split(" ");
        int p = Integer.parseInt(secondLine[0]); // 시작 x 좌표
        int q = Integer.parseInt(secondLine[1]); // 시작 y 좌표

        int t = Integer.parseInt(br.readLine().trim()); // t 시간 후 좌표 확인

        // t 시간 후의 x, y 좌표를 계산
        int x = (p + t) % (2 * w);
        int y = (q + t) % (2 * h);

        // 개미의 좌우 반사 효과 처리
        if (x > w) {
            x = 2 * w - x;
        }

        // 개미의 상하 반사 효과 처리
        if (y > h) {
            y = 2 * h - y;
        }

        sb.append(x).append(" ").append(y);
        bw.write(sb.toString());
        bw.close();
    }
}

