import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		
		long result = 0;
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			int number = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty() && stack.peek() <= number) {
				stack.pop();
			}
			
			stack.push(number);
			
			result += stack.size()-1;
			
		}
		
		
		sb.append(result);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}