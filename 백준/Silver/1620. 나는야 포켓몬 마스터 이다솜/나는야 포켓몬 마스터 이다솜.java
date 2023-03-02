import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> valueMap = new HashMap<String, Integer>();
		HashMap<Integer, String> keyMap = new HashMap<Integer, String>();
		
		for(int i=0; i<N; i++) {
			String key = br.readLine();
			valueMap.put(key, i+1);
			keyMap.put(i+1, key);
		}
		
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			if(isNumeric(s)) {
				sb.append(keyMap.get(Integer.parseInt(s))).append("\n");
			} else {
				sb.append(valueMap.get(s)).append("\n");
			}
		}
		
		
		System.out.println(sb);
		
	}
	
	public static boolean isNumeric(String str) {
	    if (str == null) {
	        return false;
	    }
	    try {
	        Double.parseDouble(str);
	        return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	}

}