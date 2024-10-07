import java.io.*;

public class Main {

    static int[][] arr;
    static boolean[] visited;
    static int N, B, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(br.readLine().trim());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        String[] s = br.readLine().trim().split(" ");

        int A = Integer.parseInt(s[0]);
        B = Integer.parseInt(s[1]);

        int M = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < M; i++) {
            s = br.readLine().trim().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            arr[from][to] = arr[to][from] = 1;
        }

        ans = -1;

        dfs(A, 0);

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    static void dfs(int node, int count) {
        visited[node] = true;

        if (node == B) {
            ans = count;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (arr[node][i] == 1 && !visited[i]) {
                dfs(i, count + 1);
            }
        }

    }
}
