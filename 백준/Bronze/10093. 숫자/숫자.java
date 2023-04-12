import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		if(a == b) {
			sb.append(0);
		} else {
			if(a > b) {
				long temp = b;
				b = a;
				a = temp;
			}
			
			long[] array = new long[(int)(b-a-1)];
			
			
			for(long i=0; i<array.length; i++) {
				array[(int)i] = i+a+1;
			}
			
			sb.append(b-a-1).append("\n");
			for(long i=0; i<array.length; i++) {
				sb.append(array[(int)i] + " ");
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}