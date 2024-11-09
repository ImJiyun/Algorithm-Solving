import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static List<Integer> path;
    static List<Integer> tempPath;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine().trim());
        ans = Integer.MAX_VALUE;
        visited = new int[N + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        path = new ArrayList<>();
        tempPath = new ArrayList<>();

        solve(N, 0);

        sb.append(ans).append("\n");
        for (int num : path) {
            sb.append(num).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void solve(int current, int count) {

        if (current == 1) {
            if (count < ans) {
                ans = count;
                path = new ArrayList<>(tempPath);
                path.add(1);
            }
            return;
        }

        if (visited[current] <= count) {
            return;
        }

        visited[current] = count;
        tempPath.add(current);

        if (current % 3 == 0) {
            solve(current / 3, count + 1);
        }

        if (current % 2 == 0) {
            solve(current / 2, count + 1);
        }

        solve(current - 1, count + 1);

        tempPath.remove(tempPath.size() - 1); 
    }
}
