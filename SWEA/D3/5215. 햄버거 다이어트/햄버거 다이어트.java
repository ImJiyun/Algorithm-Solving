import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int L;
    static int[] reviews;
    static int[] calories;
    static boolean[] isSelected;
    static List<Integer> sums;

    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] firstLine = br.readLine().trim().split(" ");
            N = Integer.parseInt(firstLine[0]); // 재료의 수
            L = Integer.parseInt(firstLine[1]); // 기준 칼로리

            reviews = new int[N];
            calories = new int[N];
            isSelected = new boolean[N];
            sums = new ArrayList<>();

            for (int n = 0; n < N; n++) {
                String[] line = br.readLine().trim().split(" ");
                reviews[n] = Integer.parseInt(line[0]);
                calories[n] = Integer.parseInt(line[1]);
            }

            subset(0);

            int maxReview = Collections.max(sums);
            sb.append("#").append(tc).append(" ").append(maxReview).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    static void subset(int idx) {
        // 기저 조건
        if (idx == N) {
            int totalCalories = 0;
            int totalReviews = 0;
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    totalCalories += calories[i];
                    totalReviews += reviews[i];
                }
            }

            if (totalCalories <= L) sums.add(totalReviews);
            return;
        }

        isSelected[idx] = true;
        subset(idx + 1);

        isSelected[idx] = false;
        subset(idx + 1);

    }
}
