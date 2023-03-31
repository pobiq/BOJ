import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int result = 0;
	static int N, M, K;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = 1;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		int count = 1;
		
		int[] dx = {0, 0, 1, -1};
		int[] dy = {-1, 1, 0, 0};
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int i=0; i<4; i++) {
				int xx = temp[0] + dx[i];
				int yy = temp[1] + dy[i];
				
				if(xx >=0 && xx < N && yy >= 0 && yy < M && map[xx][yy] == 1 && !visited[xx][yy]) {
					count++;
					queue.add(new int[] {xx, yy});
					visited[xx][yy] = true;
				}
				
			}
		}
		
		if(result < count) {
			result = count;
		}
		
	}
	
}