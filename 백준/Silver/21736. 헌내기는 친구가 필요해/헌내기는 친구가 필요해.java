import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result = 0;
	static int n,m;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		visited = new boolean[n][m];
		
		int startX = 0;
		int startY = 0;
		
		for(int i=0; i<n; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				map[i][j] = temp[j];
				if(temp[j] == 'I') {
					startX = i;
					startY = j;
				}
			}
		}
		
		bfs(startX, startY);
		
		if(result == 0) {
			sb.append("TT");
		} else {
			sb.append(result);
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
				
				if(xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
				
				if(map[xx][yy] == 'X' || visited[xx][yy]) continue;
				
				visited[xx][yy] = true;
				if(map[xx][yy] == 'P') {
					result++;
				}
				queue.add(new int[] {xx, yy});
				
			}
			
		}
	}
	
}