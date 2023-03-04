import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int value = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int index = (int)Math.pow(2, N);
		
		count(index, r, c);
		
		sb.append(value);
	
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	public static void count(int N, int r, int c) {
		
		if(N > 1) {
			if(r < N/2 && c < N/2) {
				count(N/2, r, c);
			} else if(r < N/2 && c >= N/2) {
				value += (N*N/4);
				count(N/2, r, c-N/2);
			} else if(r >= N/2 && c < N/2) {
				value += (N*N/2);
				count(N/2, r-N/2, c);
			} else if(r >= N/2 && c >= N/2) {
				value += (N*N/4);
				value += (N*N/2);
				count(N/2, r-N/2, c-N/2);
			}
		}
	}
}