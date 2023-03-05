import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int value = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int min = Integer.MAX_VALUE;
		int sum = 0;
		
		for(int i=0; i<7; i++) {
			int number = Integer.parseInt(br.readLine());
			
			if(number % 2 == 1) {
				sum += number;
				if(min > number) {
					min = number;
				}
			}
		}
		
		if(sum == 0) {
			sb.append(-1);
		} else {
			sb.append(sum + "\n");
			sb.append(min);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}
