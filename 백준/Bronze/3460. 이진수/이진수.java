import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static int value = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		
		
		for(int i=0; i<T; i++) {
			int number = Integer.parseInt(br.readLine());
			
			String str = Integer.toBinaryString(number);
			List<Integer> list = new ArrayList<Integer>();
			
			for(int j=str.length()-1; j>-1; j--) {
				char c = str.charAt(j);
				if(c == '1') {
					list.add(Math.abs(j-(str.length()-1)));
				}
			}
			
			for(int n : list) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}