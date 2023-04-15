import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int K, W, H;
	static int[][][] map;
	static boolean[][][] visited;
	static int[] dx1 = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy1 = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dx2 = {-1, 1, 0, 0};
	static int[] dy2 = {0, 0, -1, 1};
	
	static class Monkey{
		int x;
		int y;
		int k;
		
		public Monkey(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W][K+1];
		visited = new boolean[H][W][K+1];
		
		int[][] array = new int[H][W];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value == 1) {
					value = -1;
				}
				array[i][j] = value;
			}
		}
		
		for(int k=0; k<=K; k++) {
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j][k] = array[i][j];
				}
			}
		}
		
		
		visited[0][0][0] = true;
		bfs(0, 0, 0);
		
		boolean flag = false;
		int index = 0;
		for(int i=0; i<=K; i++) {
			if(visited[H-1][W-1][i]) {
				flag = true;
				index = i;
			}
		}
		
		if(flag) {
			sb.append(map[H-1][W-1][index]);
		} else {
			sb.append(-1);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void bfs(int a, int b, int c) {
		Queue<Monkey> queue = new LinkedList<>();
		queue.add(new Monkey(a, b, c));
		
		while(!queue.isEmpty()) {
			Monkey m = queue.poll();
			int x = m.x;
			int y = m.y;
			int k = m.k;
			
			if(x == H-1 && y == W-1) {
				return;
			}
			
			if(k < K) {
				for(int i=0; i<8; i++) {
					int xx = x + dx1[i];
					int yy = y + dy1[i];
					
					if(xx < 0 || xx >= H || yy < 0 || yy >= W) continue;
					
					if(visited[xx][yy][k+1] || map[xx][yy][k+1] == -1) continue;
					
					visited[xx][yy][k+1] = true;
					map[xx][yy][k+1] = map[x][y][k] + 1;
					queue.add(new Monkey(xx, yy, k+1));
				}
			}
				
			for(int i=0; i<4; i++) {
				int xx = x + dx2[i];
				int yy = y + dy2[i];
				
				if(xx < 0 || xx >= H || yy < 0 || yy >= W) continue;
				
				if(visited[xx][yy][k] || map[xx][yy][k] == -1) continue;
				
				visited[xx][yy][k] = true;
				map[xx][yy][k] = map[x][y][k] + 1;
				queue.add(new Monkey(xx, yy, k));
			}
			
		}
	}
}