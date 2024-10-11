import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, cnt;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb  = new StringBuilder();

        N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            arr[a][b] = arr[b][a] = 1;
        }

        cnt = bfs(1); 

        sb.append(cnt);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;
        int friendCount = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int depth = current[1];

     
            if (depth >= 2) {
                continue;
            }

            for (int i = 1; i <= N; i++) {
                if (arr[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i, depth + 1});
                    friendCount++;
                }
            }
        }

        return friendCount;
    }
}
