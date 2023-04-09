import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		BigInteger result = new BigInteger(Integer.toString(n));
		
		for(int i=n-1; i>=n-m+1; i--) {
			BigInteger sub = new BigInteger(Integer.toString(i));
			result = result.multiply(sub);
			
		}
		
		for(int i=m; i>=1; i--) {
			BigInteger sub = new BigInteger(Integer.toString(i));
			result = result.divide(sub);
		}
		
		sb.append(result.toString());
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}