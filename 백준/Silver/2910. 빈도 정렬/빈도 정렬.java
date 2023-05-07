import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
		int number;
		int index;
		int count;
		
		public Node(int number, int index, int count) {
			this.number = number;
			this.index = index;
			this.count = count;
		}
		
		public String toString() {
			return this.number + " " + this.index + " " + this.count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> count_map = new HashMap<>();
		HashMap<Integer, Integer> index_map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int key = Integer.parseInt(st.nextToken());
			if(!index_map.containsKey(key)) {
				index_map.put(key, i);
			}
			
			count_map.put(key, count_map.getOrDefault(key, 0) + 1);
		}
		
		ArrayList<Node> list = new ArrayList<>();
		
		for(int key : index_map.keySet()) {
			Node node = new Node(key, index_map.get(key), count_map.get(key));
			list.add(node);
		}
		
		Collections.sort(list, (o1, o2) -> {
			if(o1.count == o2.count) {
				return o1.index - o2.index;
			}
			return o2.count - o1.count;
		});
		
		for(int i=0; i<list.size(); i++) {
			Node node = list.get(i);
			for(int j=0; j<node.count; j++) {
				sb.append(node.number + " ");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}