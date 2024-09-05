import java.io.*;
import java.util.Arrays;

public class Solution {

    static int N;
    static int[] numbers;
    static int maxNum;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input4.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            String numStr = line[0];
            N = Integer.parseInt(line[1]);
            numbers = new int[numStr.length()];

            for (int i = 0; i < numStr.length(); i++) {
                numbers[i] = numStr.charAt(i) - '0';
            }

            maxNum = 0;

            dfs(0, 0);

            sb.append("#").append(tc).append(" ").append(maxNum).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int start, int swapCount) {
        if (swapCount == N) {
            int curr = 0;

            for (int num : numbers) {
                curr = curr * 10 + num;
            }
            maxNum = Math.max(maxNum, curr);
            return;
        }

        for (int i = start; i < numbers.length - 1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                swap(i, j);
                dfs(i,swapCount+1);
                swap(i, j);
            }
        }
    }

    static void swap(int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
