import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int F, G, U, D;
    static int[] stairs;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");

        F = Integer.parseInt(s[0]);
        int S = Integer.parseInt(s[1]);
        G = Integer.parseInt(s[2]);
        U = Integer.parseInt(s[3]);
        D = Integer.parseInt(s[4]);

        stairs = new int[F + 1];
        visited = new boolean[F + 1];

        int ans = bfs(S);

        if (ans == -1) sb.append("use the stairs");
        else sb.append(ans);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int bfs(int stair) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(stair);
        visited[stair] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == G) return stairs[cur];

            if (cur + U <= F && !visited[cur + U]) {
                visited[cur + U] = true;
                stairs[cur + U] = stairs[cur] + 1;
                queue.add(cur + U);
            }

            if (cur - D >= 1 && !visited[cur - D]) {
                visited[cur - D] = true;
                stairs[cur - D] = stairs[cur] + 1;
                queue.add(cur - D);
            }
        }
        return -1;
    }
}
