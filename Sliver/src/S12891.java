import java.io.*;

public class S12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        String[] firstLine = br.readLine().trim().split(" ");
        int S = Integer.parseInt(firstLine[0]);
        int P = Integer.parseInt(firstLine[1]);

        String dnaString = br.readLine().trim();

        int[] required = new int[4];

        String[] minACGT = br.readLine().trim().split(" ");
        for (int i = 0; i < 4; i++) {
            required[i] = Integer.parseInt(minACGT[i]);
        }

        int[] current = new int[4];
        int count = 0;

        /*
        for (int i = 0; i < P; i++) {
            addCount(current, dnaString.charAt(i));
        }

        if (isValid(current, required)) {
            count++;
        }

        for (int i = P; i < S; i++) {
            addCount(current, dnaString.charAt(i));
            removeCount(current, dnaString.charAt(i - P));

            if (isValid(current, required)) {
                count++;
            }
        }

         */

        sb.append(count).append("\n");
        bw.write(sb.toString());
        bw.close();
    }

    /*
    static void addCount(int[] current, char c) {
        if (c == 'A') current[0]++;
        else if (c == 'C') current[1]++;
        else if (c == 'G') current[2]++;
        else if (c == 'T') current[3]++;
    }

    static void removeCount(int[] current, char c) {
        if (c == 'A') current[0]--;
        else if (c == 'C') current[1]--;
        else if (c == 'G') current[2]--;
        else if (c == 'T') current[3]--;
    }

    static boolean isValid(int[] current, int[] required) {
        for (int i = 0; i < 4; i++) {
            if (current[i] < required[i]) {
                return false;
            }
        }
        return true;
    }

     */
}