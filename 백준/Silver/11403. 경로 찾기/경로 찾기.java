import java.io.*;

public class Main {

    static int N;
    static int[][] arr;
    static int[][] ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine().trim());

        arr = new int[N][N];
        ans = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().trim().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int start, int node) {

        for (int i = 0; i < N; i++) {
            if (arr[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                ans[start][i] = 1;
                dfs(start, i);
            }
        }
    }
}
