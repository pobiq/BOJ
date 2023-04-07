import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static int[] arr;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		
		dfs(1, 0, m);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int start, int depth, int r) {
		if(depth == r) {
			for(int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=n; i++) {
			arr[depth] = i;
			dfs(i, depth+1, r);
		}
	}
	
}