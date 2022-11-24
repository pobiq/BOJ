import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        int mul = 1;
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
		
		for(String key : map.keySet()) {
			mul *= (map.get(key)+1);
		}
		
		answer = mul - 1;
        
        return answer;
    }
}