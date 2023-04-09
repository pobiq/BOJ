import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			char[] order = {'D', 'S', 'L', 'R'};
			String[] command = new String[10000];
			boolean[] visited = new boolean[10000];
			
			Arrays.fill(command, "");
			
			Queue<Integer> queue = new LinkedList<>();
			queue.add(A);
			visited[A] = true;
			
			while(!queue.isEmpty()) {
				int x = queue.poll();
				
				if(x == B) {
					break;
				}
				
				for(int i=0; i<4; i++) {
					char c = order[i];
					int next;
					if(c == 'D') {
						next = (x*2) % 10000;
					} else if(c == 'S') {
						next = (x ==0) ? 9999 : x-1;
					} else if(c == 'L') {
						next = (x % 1000) * 10 + x/1000;
					} else {
						next = (x % 10) * 1000 + x/10;
					}
					
					if(!visited[next]) {
						queue.add(next);
						visited[next] = true;
						command[next] = command[x] + c;
					}
				}
			}
			
			sb.append(command[B]).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}