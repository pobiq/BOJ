import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		array = new int[100001];
		
		bfs(N);
		
		int answer = array[K] - 1;
		
		sb.append(answer);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	public static void bfs(int N) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		array[N] = 1;
		
		while(!q.isEmpty()) {
			int index = q.poll();
			if(index-1 >= 0 && array[index-1] == 0) {
				q.offer(index-1);
				array[index-1] = array[index] + 1;
			}
			if(2*index <= 100000 && array[2*index] == 0) {
				q.offer(2*index);
				array[2*index] = array[index] + 1;
			} 
			if(index+1 <= 100000 && array[index+1] == 0) {
				q.offer(index+1);
				array[index+1] = array[index] + 1;
			}
		}
	}
	
}