import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] adjList;
    static boolean[] visited;
    static int[] orders;
    static int N, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");

        N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int R = Integer.parseInt(s[2]);

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        orders = new int[N + 1];
        count = 1;

        for (int i = 0; i < M; i++) {
            s = br.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            adjList[a].add(b);
            adjList[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(orders[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int node) {
        visited[node] = true;
        orders[node] = count++;

        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
