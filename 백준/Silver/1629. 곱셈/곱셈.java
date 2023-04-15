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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		long result = recursive(A, B, C);
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static long recursive(long A, long B, long C) {
		if(B == 1) {
			return A % C;
		}
		long value = recursive(A, B/2, C);
		value = (value * value) % C;
		if(B % 2 == 0) return value;
		else return (value * A) % C;
	}
	
}