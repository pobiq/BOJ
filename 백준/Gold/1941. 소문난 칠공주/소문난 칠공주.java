import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] map = new char[5][5];
	static boolean[][] visited = new boolean[5][5];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result = 0;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		dfs(0, 0, 0, 0, new int[7]);
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void dfs(int start, int depth, int s_count, int y_count, int[] output) {
		
		if(y_count >= 4) {
			return;
		}
		
		if(depth == 7) {
			if(s_count > y_count) {
				if(bfs(output)) result++;
			}
			return;
		}
		
		
		for(int i=start; i<25; i++) {
			output[depth] = i;
			if(map[i/5][i%5] == 'S') dfs(i+1, depth+1, s_count+1, y_count, output);
			else dfs(i+1, depth+1, s_count, y_count+1, output);
		}
	}
	
	static boolean bfs(int[] output) {
		Queue<Integer> q = new LinkedList<>();
		q.add(output[0]);
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i=1; i<7; i++) {
			hs.add(output[i]);
		}
		
		int count = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0; i<4; i++) {
				int xx = now / 5 + dx[i];
				int yy = now % 5 + dy[i];
				int next = xx * 5 + yy;
				
				if(xx < 0 || xx >= 5 || yy < 0 || yy >= 5) continue;
				
				if(!hs.contains(next)) continue;
				
				hs.remove(next);
				q.add(next);
				count++;
				
			}
		}
		
		if(count == 7) {
			return true;
		}
		
		return false;
		
	} 
}
