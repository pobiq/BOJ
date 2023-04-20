import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			list.add(br.readLine());
		}
		
		Collections.sort(list, new Comparator<String>() {
			
			public int compare(String s1, String s2) {
				if(s1.length() != s2.length()) {
					return s1.length() - s2.length();
				} else {
					int sum1 = 0;
					int sum2 = 0;
					
					for(int i=0; i<s1.length(); i++) {
						String sub = s1.substring(i, i+1);
						if(isNumberic(sub)) {
							sum1 += Integer.parseInt(sub);
						}
					}
					
					for(int i=0; i<s2.length(); i++) {
						String sub = s2.substring(i, i+1);
						if(isNumberic(sub)) {
							sum2 += Integer.parseInt(sub);
						}
					}
					
					if(sum1 == sum2) {
						return s1.compareTo(s2);
					} else {
						return sum1-sum2;
					}
				}
				
			}
			
		});
		
		for(String s : list) {
			sb.append(s).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static boolean isNumberic(String input) {
		try {
			Double.parseDouble(input);
			return true;
		}
		catch (NumberFormatException e){
			return false;
		}
	}
	
}