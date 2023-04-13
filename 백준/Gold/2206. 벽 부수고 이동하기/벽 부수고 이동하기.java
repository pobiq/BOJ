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
	
	static int N,M;
	
	static int result = Integer.MAX_VALUE;
	
	static int[][] map;
	static boolean[][][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Node {
		int x;
		int y;
		int count;
		boolean destroyed;
		
		Node(int x, int y, int count, boolean destroyed) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.destroyed = destroyed;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for(int i=0; i<N; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		bfs();
		
		
		if(result == Integer.MAX_VALUE) {
			sb.append(-1);
		} else {
			sb.append(result + 1);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 0, false));
		
		visited = new boolean[N][M][2];
		
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			int count = node.count;
			boolean destroyed = node.destroyed;
			
			if(x == N-1 && y == M-1) {
				result = node.count;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
				
				// 벽이 아닐때
				if(map[xx][yy] == 0) {
					
					// 부신 벽이 한번 있다면
					if(destroyed && !visited[xx][yy][1]) {
						visited[xx][yy][1] = true;
						queue.add(new Node(xx, yy, count+1, true));
					}
					// 벽을 부시지 않았다면
					else if(!destroyed && !visited[xx][yy][0]){
						visited[xx][yy][0] = true;
						queue.add(new Node(xx, yy, count+1, false));
					}
				}
				
				// 벽일때
				else {
					
					// 벽을 안부셧다면
					if(!destroyed) {
						visited[xx][yy][1] = true;
						queue.add(new Node(xx, yy, count+1, true));
					}
					
				}
				
			}
			
		}
		
	}
	
}