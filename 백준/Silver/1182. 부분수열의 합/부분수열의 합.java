import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, S;
	static int result = 0;
	static int[] array;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		array = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		
		if(S == 0) result--;
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void dfs(int depth, int sum) {
		
		if(depth == N) {
			if(sum == S) {
				result++;
			}
			return;
		}
		
		dfs(depth+1, sum);
		dfs(depth+1, sum + array[depth]);
		
	}
}