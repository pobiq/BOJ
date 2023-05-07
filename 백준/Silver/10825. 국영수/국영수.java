import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		String[][] score = new String[n][4];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				score[i][j] = st.nextToken();
			}
		}
		
		Arrays.sort(score, (o1, o2) -> {
			if(o1[1].equals(o2[1]) && o1[2].equals(o2[2]) && o1[3].equals(o2[3])) {
				return o1[0].compareTo(o2[0]);
			}
			
			if(o1[1].equals(o2[1]) && o1[2].equals(o2[2])) {
				return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
			}
			
			if(o1[1].equals(o2[1])) {
				return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
			}
			
			return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
		});
		
		
		for(int i=0; i<n; i++) {
			sb.append(score[i][0]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	
	
}
