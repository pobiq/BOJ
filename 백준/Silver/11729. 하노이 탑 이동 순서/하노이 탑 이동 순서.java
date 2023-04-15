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
	
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		
		
		sb.append(((int)Math.pow(2, N)-1)).append("\n");
		recursive(N, 1, 3);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void recursive(int N, int start, int end) {
		if(N == 1) {
			sb.append(start + " " + end).append("\n");
			return;
		}
		
		recursive(N-1, start, 6-start-end);
		sb.append(start + " " + end).append("\n");
		recursive(N-1, 6-start-end, end);
		
	}
	
}
