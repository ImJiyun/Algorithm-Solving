import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        // A : 본인이 좋아하는 메뉴 먹음
        // B : 본인이 좋아하지 않는 메뉴 먹음
        // C : 식사하지 못함

        int N = Integer.parseInt(br.readLine().trim());
        Queue<int[]> waitingLine = new LinkedList<>();
        List<Integer> groupA = new ArrayList<>();
        List<Integer> groupB = new ArrayList<>();
        List<Integer> groupC = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().trim().split(" ");

            if (Integer.parseInt(s[0]) == 1) {
                waitingLine.add(new int[]{Integer.parseInt(s[1]), Integer.parseInt(s[2])});
            } else {
                int memuNum = Integer.parseInt(s[1]);
                int[] info = waitingLine.poll();
                if (info[1] == memuNum) groupA.add(info[0]);
                else groupB.add(info[0]);
            }
        }

        while (!waitingLine.isEmpty()) {
            int[] info = waitingLine.poll();
            groupC.add(info[0]);
        }

        Collections.sort(groupA);
        Collections.sort(groupB);
        Collections.sort(groupC);

        if (groupA.isEmpty()) sb.append("None");
        else {
            for (int i = 0; i < groupA.size(); i++) sb.append(groupA.get(i) + " ");
        }
        sb.append("\n");

        if (groupB.isEmpty()) sb.append("None");
        else {
            for (int i = 0; i < groupB.size(); i++) sb.append(groupB.get(i) + " ");
        }
        sb.append("\n");

        if (groupC.isEmpty()) sb.append("None");
        else {
            for (int i = 0; i < groupC.size(); i++) sb.append(groupC.get(i) + " ");
        }
        sb.append("\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
