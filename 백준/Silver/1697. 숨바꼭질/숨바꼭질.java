import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] ground;
    static boolean[] visited;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");
        int N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        ground = new int[100001];  
        visited = new boolean[100001];

        int ans = bfs(N);

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int bfs(int point) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(point);
        visited[point] = true;

        while (!queue.isEmpty()) {
            int polled = queue.poll();
            
            if (polled == K) return ground[K];
            
            if (polled + 1 <= 100000 && !visited[polled + 1]) {
                visited[polled + 1] = true;
                ground[polled + 1] = ground[polled] + 1;
                queue.add(polled + 1);
            }

            if (polled - 1 >= 0 && !visited[polled - 1]) {
                visited[polled - 1] = true;
                ground[polled - 1] = ground[polled] + 1;
                queue.add(polled - 1);
            }

            if (2 * polled <= 100000 && !visited[2 * polled]) {
                visited[2 * polled] = true;
                ground[2 * polled] = ground[polled] + 1;
                queue.add(2 * polled);
            }
        }

        return -1;  
    }
}
