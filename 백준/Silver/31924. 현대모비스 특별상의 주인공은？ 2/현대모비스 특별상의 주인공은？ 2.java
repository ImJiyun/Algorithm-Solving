import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int N = Integer.parseInt(br.readLine().trim());
        int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1}; // 상 하 좌 우 좌상 좌하 우상 우하
        int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};

        char[] MOBIS = {'M', 'O', 'B', 'I', 'S'};

        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'M') {
                    for (int k = 0; k < 8; k++) {
                        int count = 0;
                        for (int l = 1; l < 5; l++) {
                            int nr = i + dr[k] * l;
                            int nc = j + dc[k] * l;
                            if (nr < 0|| nr > N-1 || nc < 0|| nc > N-1) continue;
                            if (arr[nr][nc] == MOBIS[l]) count++;
                        }
                        if (count == 4)  ans++;
                    }
                }
            }
        }

        sb.append(ans).append("\n");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
