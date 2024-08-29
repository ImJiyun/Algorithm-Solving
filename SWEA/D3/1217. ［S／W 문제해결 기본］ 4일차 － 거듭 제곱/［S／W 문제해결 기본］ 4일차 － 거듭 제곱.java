import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int testCase = sc.nextInt();

            int N = sc.nextInt();
            int M = sc.nextInt();

            int answer = power(N, M);

            System.out.printf("#%d %d\n", tc, answer);
        }

    }

    static int power(int N, int M) {
        if (M <= 1) {
            return N;
        }

        if (M % 2 == 0) {
            int tmp = power(N, M/2);
            return tmp * tmp;
        } else {
            int tmp = power(N, (M-1)/2);
            return tmp * tmp * N;
        }
    }
}
