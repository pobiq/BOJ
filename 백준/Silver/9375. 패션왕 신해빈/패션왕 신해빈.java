import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<T; i++) {
			
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			int count = 1;
			
			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				
				hm.put(type, hm.getOrDefault(type, 0) + 1);
			}
			
			for(int value : hm.values()) {
				count *= (value + 1);
			}
			
			
			bw.write(Integer.toString(count-1) + "\n");
			
		}
		
		bw.flush();
		bw.close();
		
	}
	
}