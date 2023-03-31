import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		result = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			String[] array = br.readLine().split("");
			for(int j=0; j<array.length; j++) {
				map[i][j] = Integer.parseInt(array[j]);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		result.sort(Comparator.naturalOrder());
		
		sb.append(result.size()).append("\n");
		
		for(int i=0; i<result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		visited[x][y] = true;
		
		int cnt = 1;
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int i=0; i<4; i++) {
				int xx = temp[0] + dx[i];
				int yy = temp[1] + dy[i];
				
				if(xx >= 0 && xx < N && yy >= 0 && yy <N ) {
					if(map[xx][yy] == 1 && !visited[xx][yy]) {
						queue.add(new int[] {xx, yy});
						cnt++;
						visited[xx][yy] = true;
					}
				}	
			}
		}
		
		result.add(cnt);
		
	}
	
}