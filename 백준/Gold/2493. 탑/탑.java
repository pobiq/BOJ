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
		
		int[] tower = new int[N];
		int[] answer = new int[N];
		
		Stack<Integer> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N-1; i>=0; i--) {
			
			if(stack.isEmpty()) {
				stack.push(i);
			} else {
				while(!stack.isEmpty() && tower[stack.peek()] <= tower[i]) {
					answer[stack.pop()] = i+1;
				}
				stack.push(i);
			}
			
		}
		
		while(!stack.isEmpty()) {
			answer[stack.pop()] = 0;
		}
		
		for(int i : answer) {
			sb.append(i + " ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}