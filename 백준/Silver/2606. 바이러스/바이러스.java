import java.io.*;

public class Main {

    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        ans = 0;

        for (int i = 0; i < M; i++) {
            String[] s= br.readLine().trim().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            arr[a][b] = arr[b][a] = 1;
        }

        dfs(1);

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    static void dfs(int node) {
        visited[node] = true;

        for (int i = 1; i <= N; i++) {
            if (arr[node][i] == 1 && !visited[i]) {
                ans++;
                dfs(i);
            }
        }
    }
}
