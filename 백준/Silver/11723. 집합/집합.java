import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		long M = Long.parseLong(br.readLine());
		int[] S = new int[21];
		
		for(long i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			String order = st.nextToken();
			
			int x = 0;
			
			if(order.equals("add") || order.equals("remove") || order.equals("check") || order.equals("toggle")) {
				x = Integer.parseInt(st.nextToken());
			}
			
			switch(order){
				case "add":
					if(S[x] == 0) {
						S[x]++;
					}
					break;
				case "remove":
					if(S[x] == 1) {
						S[x] = 0;
					}
					break;
				case "check":
					sb.append(S[x]).append("\n");
					break;
				case "toggle":
					if(S[x] == 1) {
						S[x] = 0;
					} else {
						S[x] = 1;
					}
					break;
				case "all":
					for(int k=1; k<21; k++) {
						S[k] = 1;
					}
					break;
				case "empty":
					for(int k=1; k<21; k++) {
						S[k] = 0;
					}
					break;
			}
			
		}
		
		
		System.out.println(sb);
		
	}

}