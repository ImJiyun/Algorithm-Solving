import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(" ");
            if (queue.isEmpty()) break;
            int y = queue.poll();
            queue.offer(y);
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
