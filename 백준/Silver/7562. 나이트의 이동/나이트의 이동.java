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
		
		for(int i=0; i<t; i++) {
			int l = Integer.parseInt(br.readLine());
			int[][] chess = new int[l][l];
			boolean[][] visited = new boolean[l][l];
			int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
			int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			Queue<int[]> queue = new LinkedList<>();
			
			queue.add(new int[] {startX, startY});
			visited[startX][startY] = true;
			
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();
				int x = temp[0];
				int y = temp[1];
				
				if(x == endX && y == endY) {
					break;
				}
				
				for(int j=0; j<8; j++) {
					int xx = x + dx[j];
					int yy = y + dy[j];
					
					if(xx < 0 || xx >= l || yy < 0 || yy >= l) continue;
					
					if(visited[xx][yy]) continue;
					
					visited[xx][yy] = true;
					chess[xx][yy] = chess[x][y] + 1;
					queue.add(new int[] {xx, yy});
				}
			}
			
			sb.append(chess[endX][endY]).append("\n");
			
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	
}