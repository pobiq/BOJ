import java.util.ArrayList;
import java.util.List;

class Solution {
    
    static int result = 0;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        int end = banned_id.length;
		
		combi(user_id, banned_id, new String[end], 0, 0, end);
		
		answer = result;
        
        return answer;
    }
    
    
    static void combi(String[] user_id, String[] banned_id, String[] output, int start, int depth, int end) {
		if(depth == end) {
			List<String[]> list = setOrder(output);
			
			boolean flag = false;
			
			for(String[] sub : list) {
				int count = 0;
				for(int i=0; i<sub.length; i++) {
					String regex = banned_id[i].replaceAll("\\*", "[0-9a-z]");
					if(sub[i].matches(regex)) {
						count++;
					}
				}
				
				if(count == sub.length) {
					result++;
					break;
				}
				
			}
			
			return;
		}
		
		for(int i=start; i<user_id.length; i++) {
			output[depth] = user_id[i];
			combi(user_id, banned_id, output, i+1, depth+1, end);
		}
		
	}
	
	static List<String[]> setOrder(String[] input) {
		
		List<String[]> list = new ArrayList<>();
		
		boolean[] visited = new boolean[input.length];
		
		String[] output = new String[input.length];
		
		func(input, output, list, visited, 0);
		
		return list;
	}
	
	static void func(String[] input, String[] output, List<String[]> list, boolean[] visited, int depth) {
		if(depth == input.length) {
			String[] temp = new String[output.length];
			
			for(int i=0; i<output.length; i++) {
				temp[i] = output[i];
			}
			
			list.add(temp);
			return;
		}
		
		for(int i=0; i<input.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] =  input[i];
				func(input, output, list, visited, depth+1);
				visited[i] = false;
			}
		}
		
	}
    
}