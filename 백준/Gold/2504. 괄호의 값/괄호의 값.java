import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int temp = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                temp *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                temp *= 3;
            }
            // 닫힌 괄호 처리
            else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    ans = 0;
                    break;
                }
                if (s.charAt(i - 1) == '(') {
                    ans += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    ans = 0;
                    break;
                }
                if (s.charAt(i - 1) == '[') {
                    ans += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        if (!stack.isEmpty()) {
            ans = 0;
        }

        System.out.println(ans);
    }
}
