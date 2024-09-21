import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());

        arr = new int[N];
        String[] s = br.readLine().trim().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine().trim());
        String[] s2 = br.readLine().trim().split(" ");
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(s2[i]);
            sb.append(binarySearch(a)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key) return 1;
            else if (arr[mid] > key) right = mid - 1;
            else left = mid + 1;
        }
        return 0;
    }
}
