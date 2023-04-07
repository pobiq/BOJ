import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		int[] arr = new int[n];
		int[] out = new int[m];
		boolean[] visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		
		permutation(arr, out, visited, 0, m);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
		if(depth == r) {
			for(int i : out) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				permutation(arr, out, visited, depth+1, r);
				visited[i] = false;
			}
		}
	}
	
}