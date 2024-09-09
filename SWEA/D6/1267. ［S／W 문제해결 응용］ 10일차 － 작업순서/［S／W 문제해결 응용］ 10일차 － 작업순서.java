

import java.io.*;
import java.util.*;

public class Solution {

    static int[][] adjArr;
    static int[] degrees;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/김지윤/input_A076.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            int V = Integer.parseInt(line[0]);
            int E = Integer.parseInt(line[1]);

            adjArr = new int[V+1][V+1];
            degrees = new int[V+1];

            String[] lineTwo = br.readLine().trim().split(" ");

            for (int i = 0; i < lineTwo.length / 2; i++) {
                int A = Integer.parseInt(lineTwo[2 * i]);
                int B = Integer.parseInt(lineTwo[2 * i + 1]);
                adjArr[A][B] = 1;
                degrees[B]++;
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= V; i++) {
                if (degrees[i] == 0) queue.add(i);
            }

            sb.append("#").append(tc).append(" ");

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                sb.append(curr).append(" ");

                for (int i = 1; i < V + 1; i++) {
                    if (adjArr[curr][i] == 1) {
                        degrees[i]--;
                        adjArr[curr][i] = 0;
                        if (degrees[i] == 0) queue.add(i);
                    }
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
