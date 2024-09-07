
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[][] arr;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/김지윤/input_A070.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            int count = Integer.parseInt(line[0]);
            int start = Integer.parseInt(line[1]);

            arr = new int[101][101];
            visited = new boolean[101];

            String[] lineTwo = br.readLine().trim().split(" ");

            for (int i = 0; i < count; i += 2) {
                int from = Integer.parseInt(lineTwo[i]);
                int to = Integer.parseInt(lineTwo[i + 1]);
                arr[from][to] = 1;
            }
            bfs(start);
            sb.append("#").append(tc).append(" ").append(max).append("\n");

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
        
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        max = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int tmpMax = 0;

            for (int i = 0; i < queueSize; i++) {
                int popped = queue.poll();

                for (int j = 1; j < 101; j++) {
                    if (arr[popped][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        queue.offer(j);
                        tmpMax = Math.max(tmpMax, j);
                    }
                }
            }

            if (tmpMax != 0) max = tmpMax;
        }
    }

}
