import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	static int[] map;
	static int result = 0;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		
		dfs(0);
		
		
		sb.append(result);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void dfs(int depth) {
		if(depth == N) {
			result++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			
			map[depth] = i;
			
			if(isExist(depth)) {
				dfs(depth+1);
			}
			
		}
		
	}
	
	static boolean isExist(int index) {
		
		for(int i=0; i<index; i++) {
			if(map[index] == map[i]) {
				return false;
			}
			
			if(Math.abs(index-i) == Math.abs(map[index] - map[i])) {
				return false;
			}
		}
		
		return true;
	}
	
}