import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	
	static int[][] dp = new int[30][30];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> lowQueue = new PriorityQueue<>();
		
		while(N --> 0) {
			lowQueue.add(Integer.parseInt(br.readLine()));
		}
		
		int result = 0;
		
		while(lowQueue.size() > 1) {
			int x = lowQueue.poll();
			int y = lowQueue.poll();
			int sum = x+y;
			result += sum;
			lowQueue.add(sum);
		}
		
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}