import java.io.*;
import java.util.*;

public class S2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        ArrayList<Integer> xLengths = new ArrayList<>();
        ArrayList<Integer> yLengths = new ArrayList<>();

        String[] firstLine = br.readLine().trim().split(" ");

        // 가로 길이 xLengths에 추가
        xLengths.add(Integer.valueOf(firstLine[0]));
        // 세로 길이 yLengths에 추가
        yLengths.add(Integer.valueOf(firstLine[1]));

        // N : 자르는 횟수
        int N = Integer.parseInt(br.readLine().trim());
        // 자르는 횟수만큼 반복
        for (int n = 0; n < N; n++) {
            String[] line = br.readLine().trim().split(" ");
            // 0번째 인덱스 : 가로로 잘라야 하는가, 세로로 잘라야 하는가
            int XOrY = Integer.parseInt(line[0]);
            // 0이면 가로로 자른다. -> 세로 선이 생긴다.
            if (XOrY == 0) yLengths.add(Integer.parseInt(line[1]));
            // 1이면 세로로 자른다. -> 가로 선이 생긴다.
            else xLengths.add(Integer.parseInt(line[1]));
        }

        // 오름차순으로 정렬
        Collections.sort(xLengths);
        Collections.sort(yLengths);

        // index i의 값 = index i의 값 - index i-1의 값
        for (int i = xLengths.size() - 1; i > 0; i--) {
            xLengths.set(i, xLengths.get(i) - xLengths.get(i - 1));
        }

        // index i의 값 = index i의 값 - index i-1의 값
        for (int i = yLengths.size() - 1; i > 0; i--) {
            yLengths.set(i, yLengths.get(i) - yLengths.get(i - 1));
        }

        // 오름차순으로 정렬
        Collections.sort(xLengths);
        Collections.sort(yLengths);

        // 두 리스트의 마지막 인덱스의 값을 곱하면 최대값
        sb.append(xLengths.get(xLengths.size() - 1) * yLengths.get(yLengths.size() - 1));
        bw.write(sb.toString());
        bw.close();
    }
}
