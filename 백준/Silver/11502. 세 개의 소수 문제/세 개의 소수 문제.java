import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	
	static boolean[] prime = new boolean[1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());
		
		run();
		
		while(t --> 0) {
			int n = Integer.parseInt(br.readLine());
			
			boolean flag = true;
			
			Loop:
			for(int i=2; i<=1000; i++) {
				for(int j=2; j<=1000; j++) {
					for(int k=2; k<=1000; k++) {
						if((!prime[i] && !prime[j] && !prime[k]) && i+j+k == n) {
							flag = false;
							sb.append(i + " " + j + " " + k).append("\n");
							break Loop;
						}
					}
				}
			}
			
			if(flag) {
				sb.append(0).append("\n");
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void run() {
		
		prime[0] = true;
		prime[1] = true;
		
		for(int i=2; i<=1000; i++) {
			if(!prime[i]) {
				for(int j=i+i; j<=1000; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		
	}
	
	
}