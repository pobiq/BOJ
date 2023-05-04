import java.io.*;
import java.util.*;

public class Main {
	
	static int w,h;
	static int count = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) {
				break;
			}
			
			map = new int[h][w];
			visited = new boolean[h][w];
			count = 0;
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						visited[i][j] = true;
						bfs(i, j);
					}
				}
			}
			
			sb.append(count + "\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void bfs(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {a,b});
		
		count++;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			for(int i=0; i<8; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= h || yy < 0 || yy >= w) continue;
				
				if(visited[xx][yy] || map[xx][yy] == 0) continue;
				
				visited[xx][yy] = true;
				queue.add(new int[] {xx,yy});
			}
		}
		
	}
	
}