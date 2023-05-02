import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		
		if(n % 2 == 0) {
			sb.append("CY");
		} else {
			sb.append("SK");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}