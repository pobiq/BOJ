import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M,N,K;
	
	static int count = 0;
	static List<Integer> size = new ArrayList<>();
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];

		for(int a=0; a<K; a++) {
			
			st = new StringTokenizer(br.readLine());
			
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			
			for(int i=startX; i<endX; i++) {
				for(int j=startY; j<endY; j++) {
					map[i][j] = 1;
				}
			}
			
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j] == 0) {
					visited[i][j] = true;
					bfs(i, j);
				}
			}
		}
		
		Collections.sort(size);
		
		sb.append(size.size()).append("\n");
		
		for(int i : size) {
			sb.append(i + " ");
		}
		

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void bfs(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {a, b});
		
		int area = 0;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			area++;
			
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
				
				if(visited[xx][yy] || map[xx][yy] == 1) continue;
				
				visited[xx][yy] = true;
				queue.add(new int[] {xx,yy});
				
			}
		}
		
		size.add(area);
	}
	
	
}