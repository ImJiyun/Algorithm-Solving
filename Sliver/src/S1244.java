import java.io.*;
import java.util.StringTokenizer;

public class S1244 {

    // 스위치 상태를 나타낼 배열
    static int[] switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        // N : 스위치의 개수
        int N = Integer.parseInt(br.readLine().trim());

        // 인덱스 1번에 1번 스위치의 상태를 표시하기 위해 N + 1 길이로 설정
        switches = new int[N + 1];

        // 스위치의 상태 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int index =1;
        while (st.hasMoreTokens()) {
            switches[index++] = Integer.parseInt(st.nextToken());
        }

        // studentCount: 학생 수
        int studentCount = Integer.parseInt(br.readLine().trim());

        // 학생 수만큼 반복
        for (int i = 0; i < studentCount; i++) {
            // 한 줄 입력받기
            String[] line = br.readLine().trim().split(" ");
            // 첫 번째 수 : 성별
            int gender = Integer.parseInt(line[0]);
            // 두 번째 수 : 스위치 번호
            int switchNum = Integer.parseInt(line[1]);
            // 성별이 1일 경우, changeSwitchesForM 실행
            if (gender == 1) changeSwitchesForM(switchNum);
                // 성별이 2일 경우, changeSwitchesForF 실행
            else changeSwitchesForF(switchNum);
        }

        for (int i = 1; i < switches.length; i++) {
            sb.append(switches[i]).append(" ");
            // 한 줄에 20개씩 출력
            if (i % 20 == 0) sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    static void changeSwitchesForM(int num) {
        // num의 배수 상태 바꾸기
        for (int i = num; i < switches.length; i += num) {
            switches[i] = switches[i] == 0 ? 1 : 0;
        }
    }

    static void changeSwitchesForF(int num) {
        int startNum = num - 1;
        int endNum = num + 1;
        // 시작 구간과 끝 구간이 배열 인덱스 1보다 작거나 배열 크기보다 크면 반복문 중단
        while (startNum >= 1 && endNum <= switches.length - 1) {
            // 대칭 값들의 상태가 일치하지 않을 경우 반복문 중단
            if (switches[startNum] != switches[endNum]) break;
            // startNum, endNum 각각 1씩 감소, 증가
            startNum--;
            endNum++;
        }
        // 주어진 구간의 상태 바꾸기
        for (int i = startNum + 1; i <= endNum - 1; i++) {
            switches[i] = switches[i] == 0 ? 1 : 0;
        }
    }
}

