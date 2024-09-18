import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int N = Integer.parseInt(br.readLine().trim());

        int count = 0;

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine().trim();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (stack.empty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            if (stack.empty()) count++;
        }

        sb.append(count);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
