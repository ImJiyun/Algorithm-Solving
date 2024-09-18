import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int N = Integer.parseInt(br.readLine().trim());

        String expression = br.readLine().trim();


        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine().trim());
        }

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                double num2 = stack.pop();
                double num1 = stack.pop();
                double ans;

                if (c == '+') ans = num1 + num2;
                else if (c == '-') ans = num1 - num2;
                else if (c == '*') ans = num1 * num2;
                else ans = num1 / num2;

                stack.push(ans);
            } else {
                stack.push((double) numbers[c - 'A']);
            }
        }

        sb.append(String.format("%.2f", stack.pop()));
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
