import java.io.*;
import java.util.Stack;

public class B2605 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int studentNum = Integer.parseInt(br.readLine().trim());
        String[] nums = br.readLine().trim().split(" ");
        for (int i = 0; i < studentNum; i++) {
            int num = Integer.parseInt(nums[i]);
            if (num == 0) stack1.push(i + 1);
            else {
                while (num > 0) {
                    int previousOne = stack1.pop();
                    stack2.push(previousOne);
                    num--;
                }
                stack1.push(i + 1);
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
                
            }
        }
        int[] result = new int[stack1.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack1.pop();
        }

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
