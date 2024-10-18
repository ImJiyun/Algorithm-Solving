import java.io.*;
import java.util.Arrays;

public class Main {

    static int N, minDiff;
    static int[][] attributes;
    static int[] sameTeam;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine().trim());

        attributes = new int[N][N];
        sameTeam = new int[N/2];
        minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String[] s= br.readLine().trim().split(" ");
            for (int j = 0; j < N; j++) {
                attributes[i][j] = Integer.parseInt(s[j]);
            }
        }

        findSameTeam(0, 0);

        sb.append(minDiff);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void findSameTeam(int idx, int start) {
        if (idx == N /2) {
            calDiff();
            return;
        }

        for (int i = start; i < N; i++) {
            sameTeam[idx] = i;
            findSameTeam(idx+1, i+1);
        }
    }

    static void calDiff() {
        boolean[] isSelected = new boolean[N];
        for (int i = 0; i < N / 2; i++) {
            isSelected[sameTeam[i]] = true;
        }

        int startTeamSum = 0;
        int linkTeamSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isSelected[i] && isSelected[j]) startTeamSum += attributes[i][j] + attributes[j][i];
                else if (!isSelected[i] && !isSelected[j]) linkTeamSum += attributes[i][j] + attributes[j][i];
            }
        }
        minDiff = Math.min(minDiff, Math.abs(startTeamSum - linkTeamSum));
    }
}
