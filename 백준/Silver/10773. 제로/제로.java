import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int sum = 0;
		
		for(int i=0; i<K; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				stack.pop();
			} else {
				stack.push(n);
			}
		}
		
		
		for(int i=0; i<stack.size(); i++) {
			sum += stack.get(i);
		}
		
		sb.append(sum);
		
		
		System.out.println(sb);
		
	}
	

}