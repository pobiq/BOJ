import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C;
	static char[][] map;
	static int[][] dist;
	static int startX, startY;
	static boolean[][] visited;
	static int result = -1;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		dist = new int[R][C];
		Queue<int[]> fireQ = new LinkedList<>();
		
		for(int i=0; i<R; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				if(temp[j] == '#') {
				} else if(temp[j] == 'F') {
					fireQ.add(new int[] {i, j});
					visited[i][j] = true;
				} else if(temp[j] == 'J') {
					startX = i;
					startY = j;
				}
				map[i][j] = temp[j];
			}
		}
		
		while(!fireQ.isEmpty()) {
			int[] temp = fireQ.poll();
			int x = temp[0];
			int y = temp[1];
			
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= R || yy < 0 || yy >= C) continue;
				
				if(visited[xx][yy] || map[xx][yy] == '#') continue;
				
				visited[xx][yy] = true;
				dist[xx][yy] = dist[x][y] + 1;
				fireQ.add(new int[] {xx, yy});
				
			}
		}
		
		visited = new boolean[R][C];
		visited[startX][startY] = true;
		dist[startX][startY] = 0;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startX, startY});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			if(x == 0 || x == R-1 || y == 0 || y == C-1) {
				result = dist[x][y];
				break;
			}
			
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= R || yy < 0 || yy >= C) continue;
				
				if(visited[xx][yy] || map[xx][yy] == '#' || map[xx][yy] == 'F') continue;
				
				if(dist[xx][yy] == 0 || dist[xx][yy] > dist[x][y] + 1) {
					visited[xx][yy] = true;
					dist[xx][yy] = dist[x][y] + 1;
					queue.add(new int[] {xx, yy});
				}
			}
			
		}
		
		if(result != -1) {
			sb.append(result+1);
		} else {
			sb.append("IMPOSSIBLE");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	
}