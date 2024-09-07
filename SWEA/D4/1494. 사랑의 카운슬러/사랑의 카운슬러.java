import java.io.*;

public class Solution {

    static int[][] earthWorms;
    static int[] selected;
    static int N;
    static long vectorSumMin;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("SWEA_1494_사랑의카운슬러.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            earthWorms = new int[N][2];

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().trim().split(" ");
                earthWorms[i][0] = Integer.parseInt(line[0]);
                earthWorms[i][1] = Integer.parseInt(line[1]);
            }

            vectorSumMin = Long.MAX_VALUE;
            selected = new int[N / 2];     

            findCombinations(0, 0);
            sb.append("#").append(tc).append(" ").append(vectorSumMin).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void findCombinations(int idx, int start) {
        if (idx == N / 2) {
            calculateVectorSum();
            return;
        }

        for (int i = start; i < N; i++) {
            selected[idx] = i;
            findCombinations(idx + 1, i + 1); // i + 1로 수정
        }
    }

    static void calculateVectorSum() {
        boolean[] isSelected = new boolean[N];
        for (int i = 0; i < N / 2; i++) {
            isSelected[selected[i]] = true;
        }

        long x = 0;
        long y = 0;

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) {
                x += earthWorms[i][0];
                y += earthWorms[i][1];
            } else {
                x -= earthWorms[i][0];
                y -= earthWorms[i][1];
            }
        }

        long vectorSum = x * x + y * y;
        vectorSumMin = Math.min(vectorSum, vectorSumMin);
    }
}
