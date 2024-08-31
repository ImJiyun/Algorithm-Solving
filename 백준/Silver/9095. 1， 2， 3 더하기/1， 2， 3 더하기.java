import java.io.*;

public class Main {

    static int count;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            count = 0;

            permutate(0);

            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void permutate(int currentSum) {
        if (currentSum == N) {
            count++;
            return;
        }

        if (currentSum > N) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            permutate(currentSum + i);
        }
    }
}
