import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			String p = br.readLine();

			int n = Integer.parseInt(br.readLine());
			String temp = br.readLine();
			String[] tempArray = temp.substring(1, temp.length()-1).split(",");
			
			Deque<String> deque = new LinkedList<>();
			
			for(int i=0; i<n; i++) {
				deque.add(tempArray[i]);
			}
			
			boolean flag = false;
			boolean reverse = false;
			
			for(int i=0; i<p.length(); i++) {
				char c = p.charAt(i);
				
				if(c == 'R') {
					if(reverse) {
						reverse = false;
					} else {
						reverse = true;
					}
				} else {
					if(deque.isEmpty()) {
						flag = true;
						break;
					}
					
					if(reverse) {
						deque.pollLast();
					} else {
						deque.pollFirst();
					}
				}
			}
			
			if(flag) {
				sb.append("error").append("\n");
			} else {
				sb.append("[");
				if(reverse) {
					while(!deque.isEmpty()) {
						sb.append(deque.pollLast());
						if(deque.size() > 0) {
							sb.append(",");
						}
					}
				} else {
					while(!deque.isEmpty()) {
						sb.append(deque.pollFirst());
						if(deque.size() > 0) {
							sb.append(",");
						}
					}
				}
				sb.append("]").append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}