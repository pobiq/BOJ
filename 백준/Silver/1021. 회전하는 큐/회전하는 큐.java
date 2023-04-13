import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;
		
		Deque<Integer> deque = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			deque.add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x == deque.peekFirst()) {
				deque.pollFirst();
			} else {
				
				Deque<Integer> case1 = new LinkedList<>();
				Deque<Integer> case2 = new LinkedList<>();
				
				while(!deque.isEmpty()) {
					int y = deque.pollFirst();
					case1.add(y);
					case2.add(y);
				}
				
				int left = 0;
				int right = 0;
				
				while(case1.peekFirst() != x) {
					left++;
					case1.addLast(case1.pollFirst());
				}
				
				while(case2.peekFirst() != x) {
					right++;
					case2.addFirst(case2.pollLast());
				}
				
				if(left <= right) {
					result += left;
					case1.pollFirst();
					deque = case1;
				} else {
					result += right;
					case2.pollFirst();
					deque = case2;
				}
				
			}
			
			
		}
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}