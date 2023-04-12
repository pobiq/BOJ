import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] array = new int[4];
			int count = 0;
			for(int j=0; j<4; j++) {
				array[j] = Integer.parseInt(st.nextToken());
				if(array[j] == 1) {
					count++;
				}
			}
			
			if(count == 3) {
				sb.append("A");
			} else if(count == 2) {
				sb.append("B");
			} else if(count == 1) {
				sb.append("C");
			} else if(count == 0) {
				sb.append("D");
			} else {
				sb.append("E");
			}
			sb.append("\n");
			
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}