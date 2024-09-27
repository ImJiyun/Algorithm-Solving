import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        String[] s = br.readLine().trim().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        long T = Integer.parseInt(s[2]);

        int[] scales = new int[N];
        String[] s2 = br.readLine().trim().split(" ");
        for (int i = 0; i < N; i++) {
            scales[i] = Integer.parseInt(s2[i]);
        }

        Arrays.sort(scales);

        for (int i = 0; i < N; i++) {
            if (scales[i] < T) stack.push(scales[i]);
            else queue.add(scales[i]);
        }

        for (int i = 0; i < K; i++) {
            if (stack.empty()) break;
            else {
                long top = stack.pop();
                T += top;
                while (!queue.isEmpty() && queue.peek() < T) {
                    stack.push(queue.poll());
                }
            }
        }

        // 1 5 10 15 24
        // stack : 1 5
        // queue : 10 15 24


        sb.append(T);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
