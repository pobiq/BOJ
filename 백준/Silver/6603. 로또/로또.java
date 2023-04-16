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
	
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		while(true) {
			String s = br.readLine();
			if(s.equals("0")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(s);
			
			int k = Integer.parseInt(st.nextToken());
			
			int[] array = new int[k];
			int[] output = new int[6];
			
			for(int i=0; i<k; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(array, output, 0, 0, 6, k);
			sb.append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void dfs(int[] array, int[] output, int start, int depth, int end, int k) {
		
		if(depth == end) {
			for(int i : output) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<k; i++) {
			output[depth] = array[i];
			dfs(array, output, i+1, depth+1, end, k);
		}
	}
}