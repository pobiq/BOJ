import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}
		
		int count = 0;
		
		for(int i=1; i<=N; i++) {
			if(visited[i] == false) {
				dfs(i);
				count++;
			}
		}
		
		
		sb.append(count);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	public static void dfs(int index) {
		if(visited[index] == false) {
			visited[index] = true;
			for(int i=1; i<map.length; i++) {
				if(map[index][i] == 1) {
					dfs(i);
				}
			}
		}
	}
}