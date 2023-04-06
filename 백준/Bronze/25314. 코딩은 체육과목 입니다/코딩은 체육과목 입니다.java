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
		
		int N = Integer.parseInt(br.readLine());
		sb.append("long int");
		
		while(N > 4) {
			N -= 4;
			sb.insert(0, "long ");
		}

		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	
}