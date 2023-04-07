import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			int k = Integer.parseInt(br.readLine());
			
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			
			while(k --> 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String order = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				
				if(order.equals("I")) {
					treeMap.put(number, treeMap.getOrDefault(number, 0) + 1);
				} else {
					if(treeMap.isEmpty()) continue;
					
					if(number == -1) {
						int minKey = treeMap.firstKey();
						if(treeMap.get(minKey) == 1) {
							treeMap.remove(minKey);
						} else {
							treeMap.put(minKey, treeMap.get(minKey) - 1);
						}
					} else {
						int maxKey = treeMap.lastKey();
						if(treeMap.get(maxKey) == 1) {
							treeMap.remove(maxKey);
						} else {
							treeMap.put(maxKey, treeMap.get(maxKey) - 1);
						}
					}
				}
			}
			
			if(treeMap.isEmpty()) {
				sb.append("EMPTY").append("\n");
			} else {
				sb.append(treeMap.lastKey() + " " + treeMap.firstKey()).append("\n");
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}