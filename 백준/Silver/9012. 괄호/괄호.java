import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(') stack.push(c);
                else {
                    if (stack.isEmpty()) stack.push(c);
                    if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                }
            }
            if (!stack.isEmpty()) sb.append("NO").append("\n");
            else sb.append("YES").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
