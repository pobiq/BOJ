import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[2000001];
		
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(br.readLine()) + 1000000;
			count[value]++;
		}
		
		for(int i=0; i<2000001; i++) {
			while(count[i] > 0) {
				count[i]--;
				sb.append(i - 1000000).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}