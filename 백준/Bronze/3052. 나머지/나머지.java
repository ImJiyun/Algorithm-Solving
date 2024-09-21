import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine().trim());
            set.add(num % 42);
        }

        sb.append(set.size());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
