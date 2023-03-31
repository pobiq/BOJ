import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] edgeCount = new int[N+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<=N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(y);
			edgeCount[y]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<edgeCount.length; i++) {
			if(edgeCount[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int studentNo = q.poll();
			sb.append(studentNo + " ");
			
			List<Integer> list = graph.get(studentNo);
			
			for(int i=0; i<list.size(); i++) {
				int temp = list.get(i);
				edgeCount[temp]--;
				if(edgeCount[temp] == 0) {
					q.offer(temp);
				}
			}
			
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}