import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		dist = new int[n][m];
		
		int startX = 0;
		int startY = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					startX = i;
					startY = j;
				}
			}
		}
		
		dist[startX][startY] = 0;
		visited[startX][startY] = true;
		bfs(startX, startY);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(dist[i][j] == 0 && map[i][j] == 1) {
					dist[i][j] = -1;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sb.append(dist[i][j] + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void bfs(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startX, startY});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 ||  xx >= n || yy < 0 || yy >= m) continue;
				
				if(map[xx][yy] == 0 || visited[xx][yy]) continue;
				
				visited[xx][yy] = true;
				dist[xx][yy] = dist[x][y] + 1;
				queue.add(new int[] {xx, yy});
				
			}
		}
		
	}
	
}