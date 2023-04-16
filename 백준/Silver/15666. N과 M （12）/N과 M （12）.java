import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N;
	static int[] array;
	static boolean[] visited;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		dfs(0, 0, new int[M]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void dfs(int start, int depth, int[] output) {
		
		if(depth == M) {
			for(int i : output) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		int before = 0;
		for(int i=start; i<N; i++) {
			if(before != array[i]) {
				output[depth] = array[i];
				before = array[i];
				dfs(i, depth+1, output);
			}
		}
	}
}