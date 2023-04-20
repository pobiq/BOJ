import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(sc.next());
		long[] array = new long[n];
		
		for(int i=0; i<n; i++) {
			StringBuffer sub = new StringBuffer();
			sub.append(sc.next()).reverse();
			array[i] = Long.parseLong(sub.toString());
		}
		
		Arrays.sort(array);
		
		for(long i : array) {
			sb.append(i).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}