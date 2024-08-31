import java.io.*;
import java.util.*;

public class S2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int N = Integer.parseInt(br.readLine().trim());

        int[] heights = new int[1001];

        // 입력받은 기둥 높이를 저장
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().trim().split(" ");
            int L = Integer.parseInt(line[0]);
            int H = Integer.parseInt(line[1]);
            heights[L] = H;
        }

        // 높이 배열을 복사하고 정렬하여 최대 높이를 찾음
        int[] copyHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copyHeights);

        // 최대 높이 계산
        int maxHeight = copyHeights[copyHeights.length - 1];

        int area = 0;

        // 왼쪽에서 최대 높이까지의 영역 계산
        int leftIdx = 0;
        int leftHeight = 0;
        for (int i = 0; i <= 1000; i++) {
            if (heights[i] > leftHeight) {
                area += (i - leftIdx) * leftHeight;
                leftHeight = heights[i];
                leftIdx = i;
            }
            if (heights[i] == maxHeight) break;
        }

        // 오른쪽에서 최대 높이까지의 영역 계산
        int rightIdx = 1000;
        int rightHeight = 0;
        for (int i = 1000; i >= 0; i--) {
            if (heights[i] > rightHeight) {
                area += (rightIdx - i) * rightHeight;
                rightHeight = heights[i];
                rightIdx = i;
            }
            if (heights[i] == maxHeight) break;
        }

        // 최대 높이가 차지하는 영역을 계산하여 추가
        area += maxHeight * (rightIdx - leftIdx + 1);

        sb.append(area);
        bw.write(sb.toString());
        bw.close();
    }
}