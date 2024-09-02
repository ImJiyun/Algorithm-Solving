import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder(100);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());

        generatePrimeNumbers(N, "");

        bw.write(sb.toString());
        bw.close();
    }

    static void generatePrimeNumbers(int n, String current) {
        if (current.length() == n) {
            sb.append(current).append("\n");
            return;
        }

        for (int i = 1; i <= 9; i++) {
            String next = current + i;
            if (isPrimeNumber(Integer.parseInt(next))) {
                generatePrimeNumbers(n, next);
            }
        }
    }

    static boolean isPrimeNumber(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
