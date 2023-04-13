import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		
		int N = Integer.parseInt(br.readLine());
		
		
		int result = 0;
		
		for(int i=0; i<N; i++) {
			char[] array = br.readLine().toCharArray();
			
			Stack<Character> stack = new Stack<>();
			
			for(int j=0; j<array.length; j++) {
				if(stack.isEmpty()) {
					stack.push(array[j]);
				} else {
					if(stack.peek() == array[j]) {
						stack.pop();
					} else {
						stack.push(array[j]);
					}
				}
			}
			
			if(stack.isEmpty()) {
				result++;
			}
		}
		
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}