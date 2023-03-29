import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] classes = new int[N][2];
		int result = 0;
		PriorityQueue<Integer> Queue = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			classes[i][0] = Integer.parseInt(st.nextToken());
			classes[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(classes, (o1, o2) -> {
			return o1[0] - o2[0];
		});
		
		Queue.add(classes[0][1]);
		
		for(int i=1; i<N; i++) {
			if(Queue.peek() > classes[i][0]) {
				Queue.add(classes[i][1]);
			} else {
				Queue.poll();
				Queue.add(classes[i][1]);
			}
		}
		
		result = Queue.size();
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}