import java.io.*;

public class Solution {

    static int[] p;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/김지윤/input_A065.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] NM = br.readLine().trim().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);

            p = new int[N+1];

            for (int i = 1; i < N+1; i++) {
                makeSet(i);
            }

            sb.append("#").append(tc).append(" ");

            for (int i = 0; i < M; i++) {
                String[] line = br.readLine().trim().split(" ");
                int first = Integer.parseInt(line[0]);
                int second = Integer.parseInt(line[1]);
                int third = Integer.parseInt(line[2]);

                if (first == 0) {
                    union(second, third);
                } else {
                    int a = findSet(second);
                    int b = findSet(third);
                    if (a == b) sb.append(1);
                    else sb.append(0);
                }

            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static void makeSet(int x) {
        p[x] = x;
    }

    static int findSet(int x) {
        if (x != p[x]) p[x] = findSet(p[x]);
        return p[x];
    }

    static void union(int x, int y) {
        p[findSet(y)] = findSet(x);
    }
}

