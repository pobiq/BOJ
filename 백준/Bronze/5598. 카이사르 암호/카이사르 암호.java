import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int value = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		char[] array = br.readLine().toCharArray();
		
		for(char c : array) {
			int number = (int)c - 3;
			if(number < 65) {
				number += 26;
			}
			char text = (char)number;
			sb.append(text);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}