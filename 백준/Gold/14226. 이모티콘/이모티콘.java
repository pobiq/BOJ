import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static class Step {
		int emoticon_num;
		int clipboard_num;
		int time;
		
		public Step(int emoticon_num, int clipboard_num, int time) {
			this.emoticon_num = emoticon_num;
			this.clipboard_num = clipboard_num;
			this.time = time;
		}
	}
	
	static int S;
    static boolean[][] visited = new boolean[1001][1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		S = Integer.parseInt(br.readLine());
		
		bfs();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void bfs() {
		Queue<Step> q = new LinkedList<>();
		q.add(new Step(1, 0, 0));

		while (!q.isEmpty()) {
            Step now = q.poll();
            
            int e_num = now.emoticon_num;
            int c_num = now.clipboard_num;
            int time = now.time;
            
            if(e_num == S) {
            	System.out.println(time);
            	return;
            }
            
            if(e_num > 0 && e_num <= 1000) {
            	// 1. 저장
            	if(!visited[e_num][e_num]) {
            		visited[e_num][e_num] = true;
            		q.add(new Step(e_num, e_num, time + 1));
            	}
            	// 2. 삭제
            	if(!visited[e_num -1][c_num]) {
            		visited[e_num-1][c_num] = true;
            		q.add(new Step(e_num-1, c_num, time + 1));
            	}
            	
            }
            
            if(c_num > 0 && e_num + c_num <= 1000) {
            	// 3. 불러오기
            	if(!visited[e_num + c_num][c_num]) {
            		visited[e_num + c_num][c_num] = true;
            		q.add(new Step(e_num + c_num, c_num, time+1));
            	}
            }
            
		}
	}
	
}