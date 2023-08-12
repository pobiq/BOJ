import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		
		String number = br.readLine();
		
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			int value = Character.getNumericValue(number.charAt(i));
			answer += value;
		}
		
		sb.append(answer);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}