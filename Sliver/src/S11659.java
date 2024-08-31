import java.io.*;

public class S11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        String[] firstLine = br.readLine().trim().split(" ");

        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        int[] nums = new int[N];

        String[] secondLine = br.readLine().trim().split(" ");

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(secondLine[i]);
        }

        // 누적합 배열 구하기
        for (int i = 1; i < N; i++) {
            nums[i] += nums[i-1];
        }

        for (int i = 0; i < M; i++) {
            String[] twoPoints = br.readLine().trim().split(" ");
            int startPoint = Integer.parseInt(twoPoints[0]) - 1; // 시작 인덱스
            int endPoint = Integer.parseInt(twoPoints[1]) - 1; // 끝 인덱스

            int sum;
            if (startPoint == 0) {
                sum = nums[endPoint];
            } else {
                sum = nums[endPoint] - nums[startPoint - 1];
            }
            sb.append(sum).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}

