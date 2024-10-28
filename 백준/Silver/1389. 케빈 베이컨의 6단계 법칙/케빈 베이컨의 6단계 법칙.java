import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");
        N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            s = br.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int minValue = Integer.MAX_VALUE;
        int resultNode = 1;

        for (int i = 1; i <= N; i++) {
            int sum = bfs(i);

            if (sum < minValue) {
                minValue = sum;
                resultNode = i;
            } else if (sum == minValue) {
                resultNode = Math.min(resultNode, i);
            }
        }

        sb.append(resultNode);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : list.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += distance[i];
        }
        return sum;
    }
}
