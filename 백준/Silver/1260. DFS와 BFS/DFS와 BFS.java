import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N, M, V;
	static int[][] matrix;
	
	static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().trim().split(" ");
		
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		V = Integer.parseInt(line[2]);
		
		matrix = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			String[] line2 = br.readLine().trim().split(" ");
			int src = Integer.parseInt(line2[0]);
			int dst = Integer.parseInt(line2[1]);
			matrix[src][dst] = matrix[dst][src] = 1;
		}
		
		dfs(V, new boolean[N+1]);
		sb.append("\n");
		bfs(V, new boolean[N+1]);
		
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
	
	public static void dfs(int src, boolean[] visited) {
		visited[src] = true;
		sb.append(src).append(" ");
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && matrix[src][i] == 1) {
				dfs(i, visited);
			}
			
		}
	}
	
	public static void bfs(int src, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(src);
		visited[src] = true;
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && matrix[curr][i] == 1) {
					q.offer(i);
					visited[i] = true;	
				}
				
			}
			
		}
	}

}
