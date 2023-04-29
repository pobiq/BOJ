import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<>();
		
		while(n --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			switch(order) {
			case "push":
				int number = Integer.parseInt(st.nextToken());
				deque.add(number);
				break;
			case "pop":
				if(deque.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(deque.pollFirst());
				}
				sb.append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if(deque.isEmpty()) {
					sb.append(1);
				} else {
					sb.append(0);
				}
				sb.append("\n");
				break;
			case "front":
				if(deque.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(deque.peekFirst());
				}
				sb.append("\n");
				break;
			case "back":
				if(deque.isEmpty()) {
					sb.append(-1);
				} else {
					sb.append(deque.peekLast());
				}
				sb.append("\n");
				break;
			}
			
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
