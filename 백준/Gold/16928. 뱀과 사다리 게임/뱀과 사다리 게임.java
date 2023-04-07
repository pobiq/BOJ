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
	static int M;
	static int[] board = new int[101];
	static boolean[] visited = new boolean[101];
	static int[] ladders = new int[101];
	static int[] snakes = new int[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ladders[x] = y;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			snakes[x] = y;
		}
		
		bfs(1);
		
		sb.append(board[100]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void bfs(int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		visited[index] = true;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i=1; i<=6; i++) {
				int xx = temp + i;
				
				if(xx < 0 || xx > 100) continue;
				
				if(ladders[xx] > 0) {
					xx = ladders[xx];
				}
				
				if(snakes[xx] > 0)  {
					xx = snakes[xx];
				}
				
				if(!visited[xx]) {
					board[xx] = board[temp] + 1;
					visited[xx] = true;
					queue.add(xx);
				}	
			}
		}
	}
	
	
}