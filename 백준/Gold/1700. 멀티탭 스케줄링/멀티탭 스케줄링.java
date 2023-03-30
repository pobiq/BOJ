import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] order = new int[K];
		boolean[] powered = new boolean[K+1];
		int result = 0;
		int put = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<K; i++) {
			if(!powered[order[i]]) {
				if(put < N) {
					put++;
					powered[order[i]] = true;
				} else {
					
					ArrayList<Integer> list = new ArrayList<>();
					for(int j=i; j<K; j++) {
						if(powered[order[j]] && !list.contains(order[j])) {
							list.add(order[j]);
						}
					}
					
					if(list.size() != N) {
						for(int j=0; j<K+1; j++) {
							if(powered[j] && !list.contains(j)) {
								powered[j] = false;
								break;
							}
						}
					} else {
						int remove = list.get(list.size()-1);
						powered[remove] = false;
					}
					
					powered[order[i]] = true;
					result++;
				}
			} 
		}
		
		
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
}