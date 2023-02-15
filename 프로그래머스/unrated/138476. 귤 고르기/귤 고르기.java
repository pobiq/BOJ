import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i : tangerine) {
			map.put(i, map.getOrDefault(i, 0)+ 1);
		}
		
		int remove = tangerine.length - k;
		
		List<Integer> valueList = new ArrayList<>(map.values());
		valueList.sort(Integer::compareTo);
		
		
		for(int i=0; i<valueList.size(); i++) {
			if(remove - valueList.get(i) >= 0) {
				remove -= valueList.get(i);
				valueList.set(i, 0);
			}
			
			if(remove <= 0) {
				break;
			}
			
		}
		
		for(int i :  valueList) {
			if(i != 0) {
				answer++;
			}
		}
        
        return answer;
    }
}