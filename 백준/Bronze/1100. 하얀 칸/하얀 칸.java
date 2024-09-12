import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int count = 0;

        for (int i = 0; i < 8; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < 8; j++) {
                char character = line.charAt(j);
                if (i % 2 == 0 && j % 2 == 0 && character == 'F') count++;
                if (i % 2 == 1 && j % 2 == 1 && character == 'F') count++;

            }
        }

        sb.append(count);
        bw.write(sb.toString());
        bw.close();
    }
}
