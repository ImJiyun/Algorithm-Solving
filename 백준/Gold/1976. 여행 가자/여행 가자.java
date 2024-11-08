import java.io.*;

public class Main {
    static int N, M;
    static int[][] adjArr;
    static int[] plannedCities;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine().trim());
        M = Integer.parseInt(br.readLine().trim());

        adjArr = new int[N][N];
        plannedCities = new int[M];

        // 인접 행렬 입력
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().trim().split(" ");
            for (int j = 0; j < N; j++) {
                adjArr[i][j] = Integer.parseInt(s[j]);
            }
        }

        String[] s = br.readLine().trim().split(" ");
        for (int i = 0; i < M; i++) {
            plannedCities[i] = Integer.parseInt(s[i]) - 1;
        }

        boolean canTravel = true;
        for (int i = 0; i < M - 1; i++) {
            visited = new boolean[N];
            if (!canReach(plannedCities[i], plannedCities[i + 1])) {
                canTravel = false;
                break;
            }
        }

        sb.append(canTravel ? "YES" : "NO");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean canReach(int start, int destination) {
        if (start == destination) {
            return true;
        }

        visited[start] = true;
        for (int i = 0; i < N; i++) {
            if (adjArr[start][i] == 1 && !visited[i]) {
                if (canReach(i, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
}
