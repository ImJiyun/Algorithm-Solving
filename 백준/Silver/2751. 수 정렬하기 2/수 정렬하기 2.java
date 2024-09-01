import java.io.*;

public class Main {

    static int[] arr;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int N = Integer.parseInt(br.readLine().trim());

        arr = new int[N];
        tmp = new int[N];

        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine().trim());
        }

        mergeSort(0, N-1);
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    static void mergeSort(int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid+1, right);
        merge(left, mid, right);

    }

    private static void merge(int left, int mid, int right) {
        int L = left;
        int R = mid+1;

        int idx = left;

        while (L <= mid && R <= right) {
            if (arr[L] <= arr[R]) tmp[idx++] = arr[L++];
            else tmp[idx++] = arr[R++];
        }

        if (L <= mid) {
            for (int i = L; i <= mid; i++) {
                tmp[idx++] = arr[L++];
            }
        }

        if (R <= right) {
            for (int i = R; i <= right; i++) {
                tmp[idx++] = arr[R++];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }

}
