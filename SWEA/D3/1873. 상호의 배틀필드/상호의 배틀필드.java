import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(100);

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String[] line = br.readLine().trim().split(" ");
            int H = Integer.parseInt(line[0]);
            int W = Integer.parseInt(line[1]);

            char[][] map = new char[H][W];

            int rowIdx = 0;
            int colIdx = 0;

            // 지도와 탱크 위치 초기화
            for (int r = 0; r < H; r++) {
                String mapLine = br.readLine().trim();
                for (int c = 0; c < W; c++) {
                    map[r][c] = mapLine.charAt(c);
                    if (map[r][c] == '<' || map[r][c] == '>' || map[r][c] == '^' || map[r][c] == 'v') {
                        rowIdx = r;
                        colIdx = c;
                    }
                }
            }

            int commandCount = Integer.parseInt(br.readLine().trim());
            String commands = br.readLine().trim();

            // 커맨드 처리
            for (int i = 0; i < commands.length(); i++) {
                char command = commands.charAt(i);

                if (command == 'S') {  // 발사
                    if (map[rowIdx][colIdx] == '^') {
                        for (int j = 1; rowIdx - j >= 0; j++) {
                            if (map[rowIdx - j][colIdx] == '*') {
                                map[rowIdx - j][colIdx] = '.';
                                break;
                            }
                            if (map[rowIdx - j][colIdx] == '#') break;
                        }
                    } else if (map[rowIdx][colIdx] == 'v') {
                        for (int j = 1; rowIdx + j < H; j++) {
                            if (map[rowIdx + j][colIdx] == '*') {
                                map[rowIdx + j][colIdx] = '.';
                                break;
                            }
                            if (map[rowIdx + j][colIdx] == '#') break;
                        }
                    } else if (map[rowIdx][colIdx] == '<') {
                        for (int j = 1; colIdx - j >= 0; j++) {
                            if (map[rowIdx][colIdx - j] == '*') {
                                map[rowIdx][colIdx - j] = '.';
                                break;
                            }
                            if (map[rowIdx][colIdx - j] == '#') break;
                        }
                    } else if (map[rowIdx][colIdx] == '>') {
                        for (int j = 1; colIdx + j < W; j++) {
                            if (map[rowIdx][colIdx + j] == '*') {
                                map[rowIdx][colIdx + j] = '.';
                                break;
                            }
                            if (map[rowIdx][colIdx + j] == '#') break;
                        }
                    }
                } else {  // 이동
                    char direction = map[rowIdx][colIdx];

                    if (command == 'U') {
                        direction = '^';
                        if (rowIdx - 1 >= 0 && map[rowIdx - 1][colIdx] == '.') {
                            map[rowIdx][colIdx] = '.';
                            rowIdx--;
                        }
                    } else if (command == 'D') {
                        direction = 'v';
                        if (rowIdx + 1 < H && map[rowIdx + 1][colIdx] == '.') {
                            map[rowIdx][colIdx] = '.';
                            rowIdx++;
                        }
                    } else if (command == 'L') {
                        direction = '<';
                        if (colIdx - 1 >= 0 && map[rowIdx][colIdx - 1] == '.') {
                            map[rowIdx][colIdx] = '.';
                            colIdx--;
                        }
                    } else if (command == 'R') {
                        direction = '>';
                        if (colIdx + 1 < W && map[rowIdx][colIdx + 1] == '.') {
                            map[rowIdx][colIdx] = '.';
                            colIdx++;
                        }
                    }
                    map[rowIdx][colIdx] = direction;
                }
            }

            sb.append("#").append(tc).append(" ");
            for (int r = 0; r < H; r++) {
                sb.append(map[r]);
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}