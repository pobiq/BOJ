import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int graph[][];
	static boolean visited[];
	static int min = Integer.MAX_VALUE;
	static int result = 0;
	
	static class Bacon {
		int num;
		int value;
		
		Bacon(int num, int value) {
			this.num = num;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n+1][n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = graph[y][x] = 1;
		}
		
		for(int i=1; i<=n; i++) {
			visited = new boolean[n+1];
			bfs(i);
		}
		
		
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void bfs(int start) {
		Queue<Bacon> queue = new LinkedList<>();
		queue.add(new Bacon(start, 0));
		
		visited[start] = true;
		int count = 0;
		
		while(!queue.isEmpty()) {
			Bacon b = queue.poll();
			count += b.value;
			
			for(int i=1; i<=n; i++) {
				if(graph[b.num][i] == 1 && !visited[i]) {
					queue.add(new Bacon(i, b.value + 1));
					visited[i] = true;
				}
			}
			
		}
		
		if(min > count) {
			min = count;
			result = start;
		}
	}
	
}
