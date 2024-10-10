import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[N];
        String[] s = br.readLine().trim().split(" ");
        for (int i = 0; i < N; i++) {
            if (i != 0) arr[i] = Integer.parseInt(s[i]) + arr[i-1];
            else arr[i] = Integer.parseInt(s[i]);
        }


        int M = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < M; i++) {
            s = br.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]) - 1;
            int b = Integer.parseInt(s[1]) - 1;

            int sum = 0;

            if (a == 0) sum = arr[b];
            else sum = arr[b] - arr[a - 1];

            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}
