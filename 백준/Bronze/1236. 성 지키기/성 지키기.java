import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        String[] line = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        char[][] castle = new char[N][M];
        int[] rowCount = new int[N];
        int[] colCount = new int[M];

        for (int r = 0; r < N; r++) {
            String lineTwo = br.readLine().trim();
            for (int c = 0; c < M; c++) {
                castle[r][c] = lineTwo.charAt(c);
                if (lineTwo.charAt(c) == 'X') colCount[c]++;
            }
        }

        for (int c = 0; c < M; c++) {
            for (int r = 0; r < N; r++) {
                if (castle[r][c] == 'X') rowCount[r]++;
            }
        }

        int rCount = 0;
        for (int r = 0; r < N; r++) {
            if (rowCount[r] == 0) rCount++;
        }

        int cCount = 0;
        for (int c = 0; c < M; c++) {
            if (colCount[c] == 0) cCount++;
        }

        if (rCount > cCount) sb.append(rCount);
        else sb.append(cCount);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
