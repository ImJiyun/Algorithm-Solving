import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        int[] nums = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine().trim());
            sum += nums[i];
        }

        // 산술 평균 (반올림 처리)
        sb.append(Math.round((double) sum / N)).append("\n");

        // 중앙값
        Arrays.sort(nums);
        sb.append(nums[N / 2]).append("\n");

        // 최빈값을 구하기 위한 카운팅
        int min = nums[0];
        int max = nums[N - 1];
        int[] counts = new int[max - min + 1];

        // 카운팅 배열 채우기
        for (int i = 0; i < N; i++) {
            counts[nums[i] - min]++;
        }

        // 최빈값 찾기
        int mode = nums[0];
        int maxCount = 0;
        boolean secondMode = false; // 두 번째로 작은 최빈값을 찾기 위한 플래그

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                mode = i + min;
                secondMode = false;
            } else if (counts[i] == maxCount && !secondMode) {
                mode = i + min;
                secondMode = true;
            }
        }

        sb.append(mode).append("\n");

        // 범위
        sb.append(max - min).append("\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
