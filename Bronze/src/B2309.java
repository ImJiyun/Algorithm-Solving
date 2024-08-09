import java.io.*;
import java.util.*;

// 아홉 난쟁이의 키의 합을 모두 구한다.
// 100과의 차이를 구한다.
// 리스트를 순회하며 두 수의 합이 100과의 차이 값과 동일한 두 수를 구한다.
// 그 두 수를 리스트에서 제외한다.
public class B2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        // 전체 난쟁이의 합
        int totalSum = 0;

        ArrayList<Integer> heights = new ArrayList<>();
        // 9 난쟁이의 키 입력 받기
        for (int i = 0; i < 9; i++) {
            // 키 입력 받기
            int height = Integer.parseInt(br.readLine().trim());
            // 리스트에 더하기
            heights.add(height);
            // totalSum 변수에 더하기
            totalSum += height;
        }

        // 전체 난쟁이의 키의 합과 100과의 차이 구하기
        int diff = totalSum - 100;

        int height1 = 0;
        int height2 = 0;
        // 리스트 순회
        for (int i = 0; i < heights.size(); i++) {
            for (int j = i + 1; j < heights.size(); j++) {
                // 두 키의 합이 차이 값과 같을 때
                if ((heights.get(i) + heights.get(j)) == diff) {
                    height1 = heights.get(i);
                    height2 = heights.get(j);
                    // 종료
                    break;
                }
            }
        }
        // 그 두 값을 제거
        heights.remove(Integer.valueOf(height1));
        heights.remove(Integer.valueOf(height2));

        // 오름차순 정렬
        Collections.sort(heights);
        // 출력
        for (int i = 0; i < heights.size(); i++) {
            sb.append(heights.get(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}