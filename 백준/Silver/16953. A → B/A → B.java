import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static long result = 0;
	static long A, B;
	static HashMap<Long, Long> hm = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		
		bfs(1);
		
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void bfs(long value) {
		Queue<long[]> queue = new LinkedList<>();
		queue.add(new long[] {A, value});
		
		while(!queue.isEmpty()) {
			
			long[] temp = queue.poll();
			long index = temp[0];
			long count = temp[1];
			
			if(hm.containsKey(index)) {
				if(hm.get(index) > count) {
					hm.put(index, count);
				}
			} else {
				hm.put(index, count);
			}
			
			if(index*2 <= B) {
				queue.add(new long[] {index*2, count+1});
			}
			
			long addNumber = Long.parseLong(Long.toString(index) + "1");
			if(addNumber <= B) {
				queue.add(new long[] {addNumber, count+1});
			}
			
		}
		
		if(hm.containsKey(B)) {
			result = hm.get(B);
		} else {
			result = -1;
		}
				
	}
	
}
