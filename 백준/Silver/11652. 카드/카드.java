import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int i=0; i<N; i++) {
			String key = br.readLine();
			
			hm.put(key, hm.getOrDefault(key, 0) + 1);
		}
		
		String result = "";
		int max = 0;
		
		for(String key : hm.keySet()) {
			if(max < hm.get(key)) {
				max = hm.get(key);
				result = key;
			} else if(max == hm.get(key)) {
				long d1 = Long.parseLong(result);
				long d2 = Long.parseLong(key);
				
				if(d1 > d2) {
					result = key;
				}
			}
		}
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}
