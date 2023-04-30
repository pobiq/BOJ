import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int value;
		int index;
		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Deque<Node> deque = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			while(!deque.isEmpty() && deque.peekLast().value > value) {
				deque.pollLast();
			}
			
			deque.addLast(new Node(value, i));
			
			if(deque.peekFirst().index <= i - l) {
				deque.pollFirst();
			}
			
			sb.append(deque.peekFirst().value + " ");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
