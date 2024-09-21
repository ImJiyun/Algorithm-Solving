import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().trim().split(" ");
            if (s[0].equals("push")) stack.push(Integer.parseInt(s[1]));
            else if (s[0].equals("pop")) {
                if (!stack.isEmpty()) sb.append(stack.pop());
                else sb.append(-1);
                sb.append("\n");
            }
            else if (s[0].equals("top")) {
                if (!stack.isEmpty()) sb.append(stack.peek());
                else sb.append(-1);
                sb.append("\n");
            }
            else if (s[0].equals("size")) {
                sb.append(stack.size());
                sb.append("\n");
            }
            else if (s[0].equals("empty")) {
                if (!stack.isEmpty()) sb.append(0);
                else sb.append(1);
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
