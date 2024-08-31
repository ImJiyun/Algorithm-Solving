import java.io.*;

public class Main {

    static int[] nums;
    static int N;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder(100);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine().trim());

        nums = new int[N];
        isSelected = new boolean[N];

        permutate(0);

        bw.write(sb.toString());
        bw.close();
    }

    static void permutate(int idx) {
        if (idx == N) {
            for (int i = 0; i < N; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;
            nums[idx] = i + 1;
            isSelected[i] = true;
            permutate(idx + 1);
            isSelected[i] = false;
        }
    }
}
