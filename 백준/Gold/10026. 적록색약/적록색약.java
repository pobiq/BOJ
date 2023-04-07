import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static char[][] map;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int result1 = 0;
	static int result2 = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				map[i][j] = temp[j];
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited1[i][j]) {
					bfs1(i, j);
				}
				if(!visited2[i][j]) {
					bfs2(i, j);
				}
			}
		}
		
		sb.append(result1 + " " + result2);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void bfs1(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {a, b});
		result1++;
		visited1[a][b] = true;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			char c = map[x][y];
			
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
				
				if(map[x][y] == map[xx][yy] && !visited1[xx][yy]) {
					visited1[xx][yy] = true;
					queue.add(new int[] {xx, yy});
				}
				
			}
		}
	}
	
	static void bfs2(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {a, b});
		result2++;
		visited2[a][b] = true;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			char c = map[x][y];
			
			for(int i=0; i<4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
				
				if(visited2[xx][yy]) continue;
				
				if(c == 'B') {
					if(map[x][y] == map[xx][yy]) {
						visited2[xx][yy] = true;
						queue.add(new int[] {xx, yy});
					}
				} else {
					if(map[xx][yy] == 'R' || map[xx][yy] == 'G') {
						visited2[xx][yy] = true;
						queue.add(new int[] {xx, yy});
					}
				}
				
			}
		}
	}
	
}