import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int root = 1;
		
		int[][] map = new int[N+1][N+1];
		boolean[] visited = new boolean[N+1];
		int count = 0;
		
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int key = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			map[key][value] = map[value][key] = 1;
			
		}
		
		bfs(map, visited, root);
		
		for(int i=2; i<visited.length; i++) {
			if(visited[i]) {
				count++;
			}
		}
		
		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
		
	}
	
	public static void bfs(int[][] map, boolean[] visited, int root) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(root);
		visited[root] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int j=1; j<map.length; j++) {
				if(map[temp][j] == 1 && visited[j] == false) {
					q.offer(j);
					visited[j] = true;
				}
			}
		}
	}
	
}