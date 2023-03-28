import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		int[] array = new int[W];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<W; i++) {
			int number = Integer.parseInt(st.nextToken());
			array[i] = number;
		}
		
		for(int i=1; i<W-1; i++) {
			int left = array[i];
			int right = array[i];
			
			for(int j=i-1; j>-1; j--) {
				if(left < array[j]) {
					left = array[j];
				}
			}
			
			for(int j=i+1; j<W; j++) {
				if(right < array[j]) {
					right = array[j];
				}
			}
			
			if(left != 0 && right != 0) {
				answer += (Math.min(left, right) - array[i]);
			}
			
		}
		
		sb.append(answer);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	
	

}