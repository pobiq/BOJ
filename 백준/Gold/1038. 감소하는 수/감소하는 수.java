import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	static List<Long> list = new ArrayList<>();
	static int N;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		
		if(N <= 10) {
			sb.append(N);
		} else if(N >= 1023) {
			sb.append(-1);
		} else {
			for(int i=0; i<10; i++) {
				DFS(i);
			}
			Collections.sort(list);
			sb.append(list.get(N));
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void DFS(long num) {
		list.add(num);
		long modValue = num % 10;
		if(modValue == 0) {
			return;
		}
		
		for(long i=modValue-1; i>=0; i--) {
			long newValue = num * 10 + i;
			DFS(newValue);
		}
		
	}
	
}