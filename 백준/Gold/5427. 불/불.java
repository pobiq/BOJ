import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[row][col];
			boolean[][] visited = new boolean[row][col];
			int[][] dist = new int[row][col];
			
			int[] dx = {0, 0, -1, 1};
			int[] dy = {-1, 1, 0, 0};
			
			int startX = 0;
			int startY = 0;
			
			int result = -1;
			
			Queue<int[]> fireQ = new LinkedList<>();
			
			for(int i=0; i<row; i++) {
				char[] temp = br.readLine().toCharArray();
				for(int j=0; j<col; j++) {
					if(temp[j] == '@') {
						startX = i;
						startY = j;
					} else if(temp[j] == '*') {
						fireQ.add(new int[] {i, j});
						visited[i][j] = true;
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
					
					if(xx < 0 || xx >= row || yy < 0 || yy >= col) continue;
					
					if(visited[xx][yy] || map[xx][yy] == '#') continue;
					
					visited[xx][yy] = true;
					dist[xx][yy] = dist[x][y] + 1;
					fireQ.add(new int[] {xx,yy});
					
				}
				
			}
			
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {startX, startY});
			
			visited = new boolean[row][col];
			visited[startX][startY] = true;
			dist[startX][startY] = 0;
			
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				int x = temp[0];
				int y = temp[1];
				
				if(x == 0 || x == row-1 || y == 0 || y == col-1) {
					result = dist[x][y];
					break;
				}
				
				for(int j=0; j<4; j++) {
					int xx = x + dx[j];
					int yy = y + dy[j];
					
					if(xx < 0 || xx >= row || yy < 0 || yy >= col) continue;
					
					if(visited[xx][yy] || map[xx][yy] == '#' || map[xx][yy] == '*') continue;
					
					if(dist[xx][yy] == 0 || dist[xx][yy] > dist[x][y] + 1) {
						visited[xx][yy] = true;
						dist[xx][yy] = dist[x][y] + 1;
						queue.add(new int[] {xx, yy});
					}
					
				}
			}
			
			if(result == -1) {
				sb.append("IMPOSSIBLE");
			} else {
				sb.append(result+1);
			}
			
			sb.append("\n");
			
			
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	
}