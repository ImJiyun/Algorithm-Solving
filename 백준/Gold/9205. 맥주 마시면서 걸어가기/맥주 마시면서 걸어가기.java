import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, curX, curY, desX, desY;
    static boolean[] visited;
    static int[][] csLoc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            visited = new boolean[N];


            String[] s = br.readLine().trim().split(" ");

            curX = Integer.parseInt(s[0]);
            curY = Integer.parseInt(s[1]);

            csLoc = new int[N][2];

            for (int i = 0; i < N; i++) {
                s = br.readLine().trim().split(" ");
                csLoc[i][0] = Integer.parseInt(s[0]);
                csLoc[i][1] = Integer.parseInt(s[1]);
            }
            s = br.readLine().trim().split(" ");
            desX = Integer.parseInt(s[0]);
            desY = Integer.parseInt(s[1]);

            sb.append(bfs()).append("\n");
        }


        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    static String bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {curX, curY});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int nx = cur[0];
            int ny = cur[1];

            if (getDistance(nx, ny, desX, desY) <= 1000) {
                return "happy";
            }

            for (int i = 0; i < N; i++) {
                if (!visited[i] && getDistance(nx, ny, csLoc[i][0], csLoc[i][1]) <= 1000) {
                    visited[i] = true;
                    queue.add(new int[] {csLoc[i][0], csLoc[i][1]});
                }
            }
        }

        return "sad";
    }

    static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}
