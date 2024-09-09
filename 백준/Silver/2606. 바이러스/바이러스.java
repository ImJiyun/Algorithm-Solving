import java.io.*;

public class Main {

    static int N, E;
    static int[][] adjArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        N = Integer.parseInt(br.readLine().trim());

        E = Integer.parseInt(br.readLine().trim());

        adjArr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int e = 0; e < E; e++) {
            String[] line = br.readLine().trim().split(" ");

            int to = Integer.parseInt(line[0]);
            int from = Integer.parseInt(line[1]);

            adjArr[to][from] = adjArr[from][to] = 1;

        }

        int curr = 1;
        visited[curr] = true;
        dfs(curr);

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (visited[i]) count++;
        }
        sb.append(count - 1);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int curr) {
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && adjArr[curr][i] == 1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
