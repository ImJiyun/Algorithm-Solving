import java.io.*;
import java.util.*;

public class Main {
    static int N, K, cnt;
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");
        N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);
        int X = Integer.parseInt(s[3]);

        adjList = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            s = br.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            adjList.get(a).add(b);
        }

        cnt = 0;
        list = new ArrayList<>();
        bfs(X);

        if (list.isEmpty()) {
            sb.append(-1);
        } else {
            Collections.sort(list);
            for (int node : list) {
                sb.append(node).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int cur = queue.poll();

                if (cnt == K) {
                    list.add(cur);
                }

                for (int next : adjList.get(cur)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            cnt++;
        }
    }
}
