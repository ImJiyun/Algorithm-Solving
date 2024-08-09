import java.io.*;
import java.util.HashMap;
import java.util.Map;

// 데이터가 2개이므로 Map으로 key(학년), value(학생 수)로 담을 생각을 했다.
// 남여 map을 따로 만들어서 데이터를 담았다.
public class B13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        // key ; 학년 , value : 학생 수
        Map<Integer, Integer> female = new HashMap<>();
        Map<Integer, Integer> male = new HashMap<>();

        String[] firstLine = br.readLine().trim().split(" ");
        // N : 학생 수
        int N = Integer.parseInt(firstLine[0]);
        // K : 최대 인원 수
        int K = Integer.parseInt(firstLine[1]);

        // 학생 수만큼 순회
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().trim().split(" ");
            // S : 성별
            int S = Integer.parseInt(line[0]);
            // Y : 학년
            int Y = Integer.parseInt(line[1]);
            // 여자의 경우
            if (S == 0) {
                // key 값에 학년을 넣고, value 값에 기존 학생 수 + 1만큼 넣는다.
                female.put(Y, female.getOrDefault(Y, 0) + 1);
                // 남자의 경우
            } else {
                // key 값에 학년을 넣고, value 값에 기존 학생 수 + 1만큼 넣는다.
                male.put(Y, male.getOrDefault(Y, 0) + 1);
            }
        }
        // 방의 수
        int count = 0;

        // 여자의 경우
        for (int year = 1; year <= 6; year++) {
            // 해당 학년의 학생이 있을 때
            if (female.containsKey(year)) {
                int students = female.get(year);
                count += (students + K - 1) / K;
            }
        }
        // 남자의 경우
        for (int year = 1; year <= 6; year++) {
            // 해당 학년의 학생이 있을 때
            if (male.containsKey(year)) {
                int students = male.get(year);
                count += (students + K - 1) / K;
            }
        }

        sb.append(count);
        bw.write(sb.toString());
        bw.close();
    }

}
