import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int result = 0;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
				
				combination(i, j, 0, 1, map[i][j]);
			}
		}
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void dfs(int i, int j, int depth, int sum) {
		if(depth == 4) {
			result = Math.max(result, sum);
			return;
		}
		
		for(int a=0; a<4; a++) {
			int xx = i + dx[a];
			int yy = j + dy[a];
			
			if(xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
			
			if(visited[xx][yy]) continue;
			
			visited[xx][yy] = true;
			dfs(xx, yy, depth+1, sum+map[xx][yy]);
			visited[xx][yy] = false;
		}
		
	}
	
	static void combination(int i, int j, int start, int depth, int sum) {
		if(depth == 4) {
			result = Math.max(result, sum);
			return;
		}
		
		for(int a=start; a<4; a++) {
			int xx = i + dx[a];
			int yy = j + dy[a];
			
			if(xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
			
			combination(i, j, a+1, depth+1, sum+map[xx][yy]);
		}
		
	}
	
}