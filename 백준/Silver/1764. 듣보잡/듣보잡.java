import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<N+M; i++) {
			String key = br.readLine();
			if(hm.containsKey(key)) {
				hm.put(key, 2);
			} else {
				hm.put(key, 1);
			}
		}
		
		for(String key : hm.keySet()) {
			if(hm.get(key) == 2) {
				count++;
				list.add(key);
			}
		}
		
		list.sort(Comparator.naturalOrder());
		
		sb.append(count + "\n");
		
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	

}