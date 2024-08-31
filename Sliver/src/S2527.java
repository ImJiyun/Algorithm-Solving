import java.io.*;

public class S2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        for (int i = 0; i < 4; i++) {
            String[] line = br.readLine().trim().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int p1 = Integer.parseInt(line[2]);
            int q1 = Integer.parseInt(line[3]);
            int x2 = Integer.parseInt(line[4]);
            int y2 = Integer.parseInt(line[5]);
            int p2 = Integer.parseInt(line[6]);
            int q2 = Integer.parseInt(line[7]);


            String answer = "";
            if ((x2 == p1 && y1 == q2) || (x2 == p1 && y2 == q1) || (x1 == p2 && y1 == q2) || (x1 == p2 && y2 == q1)) {
                answer = "c";
            } else if (p1 < x2 || p2 < x1 || q2 < y1 || q1 < y2) {
                answer = "d";
            }  else if (x2 == p1 || x1 == p2 || y2 == q1 || y1 == q2) {
                answer = "b";
            } else {
                answer = "a";
            }
            sb.append(answer).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}

