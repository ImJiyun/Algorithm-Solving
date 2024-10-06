import java.io.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().trim().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];


        for (int i = 0; i < M; i++) {
            s = br.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            arr[a][b] = arr[b][a] = 1;
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        sb.append(count);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int i = 1; i <= N; i++) {
            if (arr[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
