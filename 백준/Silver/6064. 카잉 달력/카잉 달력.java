import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			boolean flag = false;
			int result = 0;
			
			for(int i=x; i<(N*M); i+=M) {
				if(i % N == y) {
					result = i+1;
					flag = true;
					break;
				}
			}
			
			if(flag) {
				sb.append(result).append("\n");
			} else {
				sb.append(-1).append("\n");
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}