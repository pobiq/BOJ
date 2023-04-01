import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
    static int[] time = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		

		bfs();
		
		sb.append(time[K]-1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		
        q.add(N);
        time[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            
            if(now*2 <= 100000 && time[now*2] == 0) {
            	q.add(now*2);
            	time[now*2] = time[now];
            }
            
            if(now-1 >= 0 && time[now-1] == 0) {
            	q.add(now-1);
            	time[now-1] = time[now] + 1;
            }
            
            if(now+1 <= 100000 && time[now+1] == 0) {
            	q.add(now+1);
            	time[now+1] = time[now] + 1;
            }
            
        }
	}
	
}