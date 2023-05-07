import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] a = new int[n];
			int[] b = new int[m];
			
			int result = 0;
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(a);
			Arrays.sort(b);
			
			for(int i=0; i<n; i++) {
				for(int j=m-1; j>=0; j--) {
					if(a[i] > b[j]) {
						result += j+1;
						break;
					}
				}
			}
			
			sb.append(result).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}