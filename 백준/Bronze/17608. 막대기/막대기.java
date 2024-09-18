import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int N = Integer.parseInt(br.readLine().trim());

        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(br.readLine().trim());
        }

        int count = 0;
        int maxHeight = 0;

        for (int i = N-1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                count++;
            }
        }

        sb.append(count);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
