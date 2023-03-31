import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] result = new int[2];
	static int N, M;
	static int count = 0;
	static String[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			String[] temp = br.readLine().split("");
			for(int j=0; j<N; j++) {
				map[i][j] = temp[j];
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					String text = map[i][j];
					bfs(i, j, text);
				}
			}
		}
		
		sb.append(result[0] + " " + result[1]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void bfs(int x, int y, String text) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		int count = 1;
		
		int[] dx = {0, 0, 1, -1};
		int[] dy = {-1, 1, 0, 0};
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int i=0; i<4; i++) {
				int xx = temp[0] + dx[i];
				int yy = temp[1] + dy[i];
				
				if(xx >=0 && xx < M && yy >= 0 && yy < N && map[xx][yy].equals(text) && !visited[xx][yy]) {
					count++;
					queue.add(new int[] {xx, yy});
					visited[xx][yy] = true;
				}
				
			}
		}
		
		if(text.equals("W")) {
			result[0] += count*count;
		} else {
			result[1] += count*count;
		}
	}
	
}