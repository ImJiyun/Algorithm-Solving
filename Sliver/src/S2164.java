import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class S2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine().trim());

        for (int n = 1; n <= N; n++) {
            queue.add(n);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        int lastCard = queue.poll();

        sb.append(lastCard);
        bw.write(sb.toString());
        bw.close();
    }
}

