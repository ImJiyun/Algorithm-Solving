import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int B, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");

        int A = Integer.parseInt(s[0]);
        B = Integer.parseInt(s[1]);

        count = -1;

        bfs(A);

        sb.append(count);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void bfs(int num) {
        Queue<Long> queue = new LinkedList<>();
        queue.add((long) num);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long cur = queue.poll();

                if (cur == B) {
                    count = level;
                    return;
                }

                if (cur * 2 <= B) {
                    queue.add(cur * 2);
                }
                if (cur * 10 + 1 <= B) {
                    queue.add(cur * 10 + 1);
                }
            }
            level++;
        }
    }
}
