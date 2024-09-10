import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, p1, p2, M;
    static int[][] adjArr;
    static boolean[] visited;
    static int ans = 0;
    static boolean isFound;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        N = Integer.parseInt(br.readLine().trim());
        adjArr = new int[N+1][N+1];
        visited = new boolean[N+1];

        String[] line = br.readLine().trim().split(" ");

        p1 = Integer.parseInt(line[0]);
        p2 = Integer.parseInt(line[1]);

        M = Integer.parseInt(br.readLine().trim());

        for (int m = 0; m < M; m++) {
            String[] lineTwo = br.readLine().trim().split(" ");
            int to = Integer.parseInt(lineTwo[0]);
            int from = Integer.parseInt(lineTwo[1]);
            adjArr[to][from] = adjArr[from][to] = 1;
        }

        ans = 0;
        isFound = false;
        bfs(p1, p2);
        if (!isFound) sb.append(-1);
        else sb.append(ans - 1);

        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (end == curr) {
                    isFound = true;
                    return;
                }

                for (int j = 1; j <= N; j++) {
                    if (adjArr[curr][j] == 1 && !visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }

        }

    }
}
