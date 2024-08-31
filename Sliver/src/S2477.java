import java.io.*;

public class S2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        // 참외의 개수
        int count = Integer.parseInt(br.readLine().trim());

        // directions : 육각형의 이동 방향을 저장
        int[] directions = new int[6];
        // lengths : 이동 길이 저장
        int[] lengths = new int[6];

        // 입력 받기
        for (int i = 0; i < 6; i++) {
            String[] line = br.readLine().trim().split(" ");
            directions[i] = Integer.parseInt(line[0]);
            lengths[i] = Integer.parseInt(line[1]);
        }

        // 최대 가로 길이, 최대 세로 길이
        int maxWidth = 0, maxHeight = 0;
        // 작은 가로 길이, 작은 세로 길이
        int minWidth = 0, minHeight = 0;

        for (int i = 0; i < 6; i++) {
            if (directions[i] == 1 || directions[i] == 2) { // 동(1) 또는 서(2)
                if (lengths[i] > maxWidth) {
                    maxWidth = lengths[i]; // 최대 가로 길이 구하기
                    minHeight = lengths[(i + 3) % 6]; // 작은 세로 길이 : 최대 가로 길이의 3칸 뒤 위치
                }
            } else if (directions[i] == 3 || directions[i] == 4) { // 남(3) 또는 북(4)
                if (lengths[i] > maxHeight) {
                    maxHeight = lengths[i]; // 최대 세로 길이 구하기
                    minWidth = lengths[(i + 3) % 6]; // 작은 가로 길이 : 최대 세로 길이의 3칸 뒤 위치
                }
            }
        }

        int area = maxWidth * maxHeight - minWidth * minHeight;
        sb.append(count * area);
        bw.write(sb.toString());
        bw.close();
    }
}

